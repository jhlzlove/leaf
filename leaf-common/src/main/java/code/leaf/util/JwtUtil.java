package code.simple.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.time.Instant;
import java.util.Map;
import java.util.Objects;

/**
 * @author jhlz
 * @since 2022/9/7 23:03
 */
public class JwtUtil {

    private static final Logger log = LoggerFactory.getLogger(JwtUtil.class);
    /**
     * 签名，生成和解析默认都带此信息。如果不需要或者不想带去掉即可，注意生成和解析方法都要修改
     */
    private static final String SIGNATURE = "leaf";
    /**
     * 过期时间 单位：秒，默认 30 分钟
     */
    private static final long EXPIRED_TIME = 1800L;

    /**
     * 根据 payload 和 subject 生成 token
     *
     * @param payload 负载信息
     * @param subject 主体信息
     * @return token
     */
    public static String createToken(final Map<String, Object> payload, final String subject) {
        return generatorToken(null, payload, subject, null);
    }

    /**
     * 生成 token
     *
     * @param headers    headers
     * @param payload    payload
     * @param subject    subject
     * @param expireTime 过期时间
     * @return token
     */
    private static String
    generatorToken(Map<String, Object> headers, Map<String, Object> payload, String subject, Long expireTime) {
        JWTCreator.Builder builder = JWT.create();
        if (StringUtils.hasText(subject)) builder.withSubject(subject);
        if (Objects.nonNull(expireTime))
            builder.withExpiresAt(Instant.now().plusSeconds(expireTime));
        else
            builder.withExpiresAt(Instant.now().plusSeconds(EXPIRED_TIME));
        return builder
                // Header
                .withHeader(headers)
                // Payload
                .withPayload(payload)
                // Signature
                .sign(Algorithm.HMAC256(SIGNATURE));
    }

    /**
     * 校验 token
     *
     * @param token token
     * @return true: 验证成功；false：验证失败
     */
    public static boolean verifyToken(final String token) {
        try {
            getDecodedJWT(token);
            return true;
        } catch (AlgorithmMismatchException e) {
            log.error("token 算法不匹配：{}", e.getMessage());
            throw new AlgorithmMismatchException(e.getMessage());
        } catch (TokenExpiredException e) {
            log.error("token 过期：{}", e.getMessage());
            throw new TokenExpiredException(e.getMessage(), e.getExpiredOn());
        } catch (InvalidClaimException e) {
            log.error("token Claim 异常：{}", e.getMessage());
            throw new InvalidClaimException(e.getMessage());
        } catch (JWTVerificationException e) {
            log.error("token 解析异常：{}", e.getMessage());
            throw new JWTVerificationException(e.getMessage());
        }
    }

    /**
     * 获取过期时间
     *
     * @param token token
     * @return Instant 时间
     */
    public static Instant getExpiresAtAsInstant(final String token) {
        return getDecodedJWT(token).getExpiresAtAsInstant();
    }

    /**
     * 获取 Payload Claims
     *
     * @param token token
     * @return Payload Claims map 集合
     */
    public static Map<String, Claim> getPayloadClaims(final String token) {
        DecodedJWT jwt = getDecodedJWT(token);
        return jwt.getClaims();
    }

    /**
     * 获取指定的 Payload Claims
     *
     * @param token token
     * @param key   key
     * @return Claims
     */
    public static Claim getPayloadClaims(final String token, final String key) {
        DecodedJWT jwt = getDecodedJWT(token);
        return jwt.getClaim(key);
    }

    /**
     * 解析 token
     *
     * @param token token
     * @return DecodedJWT
     */
    private static DecodedJWT getDecodedJWT(final String token) {
        Algorithm algorithm = Algorithm.HMAC256(SIGNATURE);
        JWTVerifier verifier = JWT
                .require(algorithm)
                .build();
        return verifier.verify(token);
    }

    /**
     * 获取主体信息
     *
     * @param token token 字符串
     * @return subject
     */
    public static String getSubject(final String token) {
        return getDecodedJWT(token).getSubject();
    }
}
