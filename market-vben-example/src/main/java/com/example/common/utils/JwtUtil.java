package com.example.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jhlz
 * @time 2022/9/7 23:03
 */
public class JwtUtil {

    // 密钥
    private String secretKey = "firefly";

    // 过期时间
    private Long expirationTimeInSecond = 1000L * 60 * 30;

    // header
    private Map<String, Object> headerClaims = new HashMap<>();

    // payload
    private Map<String, Object> payloadClaims = new HashMap<>();

    private static final JwtUtil jwtOperator = new JwtUtil();

    private JwtUtil() {
    }

    public static JwtUtil getInstance() {
        return jwtOperator;
    }

    public JwtUtil withSecretKey(String secretKey) {
        this.secretKey = secretKey;
        return this;
    }

    public JwtUtil withTimeOut(Long expirationTimeInSecond) {
        this.expirationTimeInSecond = expirationTimeInSecond;
        return this;
    }

    public JwtUtil withHeader(Map<String, Object> headerClaims) {
        this.headerClaims = headerClaims;
        return this;
    }

    public JwtUtil withPayload(Map<String, Object> payloadClaims) {
        this.payloadClaims = payloadClaims;
        return this;
    }

    /**
     * 创建token
     *
     * @return
     */
    public String createToken() {
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        String token = JWT.create()
                .withExpiresAt(new Date(System.currentTimeMillis() + expirationTimeInSecond))
                // Header
                .withHeader(headerClaims)
                // Payload
                .withPayload(payloadClaims)
                // Signature
                .sign(algorithm);
        return token;
    }

    /**
     * 校验token
     *
     * @param token
     * @return
     */
    public Boolean verifyToken(String token) {
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
    public Claim getHeaderClaims(String token, String claimName) {
        DecodedJWT jwt = getDecodedJWT(token);
        return jwt.getHeaderClaim(claimName);
    }

    /**
     * 获取 Payload Claims
     *
     * @param token
     * @return
     */
    public Map<String, Claim> getPayload(String token) {
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
    public Claim getPayloadClaims(String token, String claimsName) {
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
    private DecodedJWT getDecodedJWT(String token) {
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        JWTVerifier verifier = JWT.require(algorithm)
                .build();
        return verifier.verify(token);
    }
}
