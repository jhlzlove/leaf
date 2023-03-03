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
import java.util.Objects;

/**
 * @author jhlz
 * @since 2022/9/7 23:03
 */
public class JwtUtil {

    // 签名
    private static final String SIGNATURE = "leaf";
    // 过期时间 单位：秒
    private static final long EXPIRED_TIME = 1800L;


    public static String createToken(final String subject) {
        return generatorToken(null, null, subject, null);
    }

    /**
     * 生成 token 设置过期时间
     *
     * @param payload    负载信息
     * @param expireTime 过期时间间隔，单位：s
     * @return token
     */
    public static String createToken(final Map<String, Object> payload,
                                     final Long expireTime) {
        return generatorToken(null, payload, null, expireTime);
    }

    public static String createToken(final Map<String, Object> payload) {
        return generatorToken(null, payload, null, null);
    }

    public static String createToken(final Map<String, Object> payload,
                                     final String subject) {
        return generatorToken(null, payload, subject, null);
    }

    public static String createToken(final Map<String, Object> headers,
                                     final Map<String, Object> payload, final
                                     String subject) {
        return generatorToken(headers, payload, subject, null);
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
    private static String generatorToken(final Map<String, Object> headers,
                                         final Map<String, Object> payload,
                                         final String subject,
                                         final Long expireTime) {
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
    public static boolean isExpired(final String token) {
        return Instant.now().compareTo(getExpiresAtAsInstant(token)) > 0;
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
    public static DecodedJWT getDecodedJWT(final String token) {
        Algorithm algorithm = Algorithm.HMAC256(SIGNATURE);
        JWTVerifier verifier = JWT
                .require(algorithm)
                .build();
        return verifier.verify(token);
    }
}
