package com.leaf.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.Nullable;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Map;

/**
 * @author jhlz
 * @version 1.0.0
 */
public class JwtUtil {

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
     * @return token
     */
    public static String createToken(final Map<String, Object> payload) {
        return generatorToken(null, payload, null, null);
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
    generatorToken(@Nullable Map<String, Object> headers,
                   Map<String, Object> payload,
                   @Nullable String subject, @Nullable Long expireTime) {
        JWTCreator.Builder builder = JWT.create();
        if (StringUtils.isNotEmpty(subject)) builder.withSubject(subject);
        if (ObjectUtils.isEmpty(expireTime))
            builder.withExpiresAt(Instant.now().plusSeconds(EXPIRED_TIME));
        else
            builder.withExpiresAt(Instant.now().plusSeconds(expireTime));
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
        getDecodedJWT(token);
        return true;
    }

    /**
     * 获取过期时间，为了直观，将 UTC 时间 +8
     *
     * @param token token
     * @return Instant 时间
     */
    public static Instant getExpiresAtAsInstant(final String token) {
        return getDecodedJWT(token).getExpiresAtAsInstant().plus(8, ChronoUnit.HOURS);
    }

    /**
     * 获取指定的 Payload Claims
     *
     * @param token token
     * @param key   key
     * @return Claims
     */
    public static Claim getPayloadClaim(final String token, final String key) {
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

}
