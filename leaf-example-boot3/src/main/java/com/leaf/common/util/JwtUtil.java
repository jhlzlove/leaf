package com.leaf.common.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.util.StringUtils;

import java.time.Instant;
import java.util.Map;

/**
 * @author jhlz
 * @since 2022/9/7 23:03
 */
public class JwtUtil {

    // 签名
    private static final String SIGNATURE = "leaf";
    // 过期时间 单位：秒
    private static final long EXPIRED_TIME = 1800;


    public static String createToken(String subject) {
        return generatorToken(null, null, subject);
    }

    public static String createToken(Map<String, Object> payload) {
        return generatorToken(null, payload, null);
    }

    public static String createToken(Map<String, Object> payload, String subject) {
        return generatorToken(null, payload, subject);
    }

    public static String createToken(Map<String, Object> headers, Map<String, Object> payload, String subject) {
        return generatorToken(headers, payload, subject);
    }

    /**
     * 生成 token
     *
     * @param headers headers
     * @param payload payload
     * @param subject subject
     * @return token
     */
    private static String generatorToken(Map<String, Object> headers,
                                         Map<String, Object> payload,
                                         String subject) {
        JWTCreator.Builder builder = JWT.create();
        if (StringUtils.hasText(subject)) builder.withSubject(subject);
        return builder
                .withExpiresAt(Instant.now().plusSeconds(EXPIRED_TIME))
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
    public static boolean verifyToken(String token) {
        try {
            getDecodedJWT(token);
        } catch (JWTVerificationException exception) {
            return false;
        }
        return true;
    }

    /**
     * token 是否过期
     *
     * @param token token
     * @return true：过期；false：未过期
     */
    public static boolean isExpired(String token) {
        return Instant.now().compareTo(getExpiresAtAsInstant(token)) > 0;
    }

    /**
     * 获取过期时间
     *
     * @param token token
     * @return Instant 时间
     */
    public static Instant getExpiresAtAsInstant(String token) {
        return getDecodedJWT(token).getExpiresAtAsInstant();
    }

    /**
     * 获取 Payload Claims
     *
     * @param token token
     * @return Payload Claims map 集合
     */
    public static Map<String, Claim> getPayloadClaims(String token) {
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
    public static Claim getPayloadClaims(String token, String key) {
        DecodedJWT jwt = getDecodedJWT(token);
        return jwt.getClaim(key);
    }

    /**
     * 解析 token
     *
     * @param token token
     * @return DecodedJWT
     */
    public static DecodedJWT getDecodedJWT(String token) {
        Algorithm algorithm = Algorithm.HMAC256(SIGNATURE);
        JWTVerifier verifier = JWT
                .require(algorithm)
                .build();
        return verifier.verify(token);
    }
}
