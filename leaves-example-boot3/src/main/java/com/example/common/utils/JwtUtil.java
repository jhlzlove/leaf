package com.example.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.time.Instant;
import java.util.Map;

/**
 * @author jhlz
 * @since 2022/9/7 23:03
 */
public class JwtUtil {

    // 签名
    private static final String SIGNATURE = "jhlz";
    // 过期时间 单位：秒
    private static final long EXPIRED_TIME = 1800;


    public static String createToken(String subject) {
        return generatorToken(null, null, subject);
    }

    public static String createToken(Map<String, Object> headers, Map<String, Object> payload, String subject) {
        return generatorToken(headers, payload, subject);
    }
    /**
     * 创建token
     *
     * @return
     */
    private static String generatorToken(Map<String, Object> headers, Map<String, Object> payload, String subject) {
        // Algorithm algorithm = Algorithm.HMAC256(secretKey);
        return JWT.create()
                .withExpiresAt(Instant.now().plusSeconds(EXPIRED_TIME))
                .withSubject(subject)
                // Header
                .withHeader(headers)
                // Payload
                .withPayload(payload)
                // Signature
                .sign(Algorithm.HMAC256(SIGNATURE));
    }

    /**
     * 校验token
     *
     * @param token
     * @return
     */
    public static Boolean verifyToken(String token) {
        try {
            getDecodedJWT(token);
        } catch (JWTVerificationException exception) {
            return false;
        }
        return true;
    }

    /**
     * 获取 Header Claims
     *
     * @param token
     * @param claimName
     * @return
     */
    public static Claim getHeaderClaims(String token, String claimName) {
        DecodedJWT jwt = getDecodedJWT(token);
        return jwt.getHeaderClaim(claimName);
    }

    /**
     * 获取 Payload Claims
     *
     * @param token
     * @return
     */
    public static Map<String, Claim> getPayload(String token) {
        DecodedJWT jwt = getDecodedJWT(token);
        Map<String, Claim> claims = jwt.getClaims();
        return claims;
    }

    /**
     * 获取 Payload Claims
     *
     * @param token
     * @param claimsName
     * @return
     */
    public static Claim getPayloadClaims(String token, String claimsName) {
        DecodedJWT jwt = getDecodedJWT(token);
        Claim claim = jwt.getClaim(claimsName);
        return claim;
    }

    /**
     * 解码
     *
     * @param token
     * @return
     */
    public static DecodedJWT getDecodedJWT(String token) {
        Algorithm algorithm = Algorithm.HMAC256(SIGNATURE);
        JWTVerifier verifier = JWT
                .require(algorithm)
                .build();
        return verifier.verify(token);
    }
}
