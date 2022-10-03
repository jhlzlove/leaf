package com.example.common.utils;

import com.example.common.constants.GlobalConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Map;

/**
 * @author jhlz
 * @time 2022/9/7 23:03
 * @desc: JwtUtil
 */
public class JwtUtil {

    /**
     * 创建 token，未设置过期时间
     *
     * @param claims
     * @return
     */
    public static String createToken(final Map<String, Object> claims) {
        String jwtToken = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, GlobalConstants.JWT_KEY.getBytes())
                .compact();
        return jwtToken;
    }

    /**
     * 创建 jwtToken
     *
     * @param expireTime 过期时间
     * @param claims     claims
     * @return
     */
    public static String createToken(final LocalDateTime expireTime, final Map<String, Object> claims) {
        String jwtToken = Jwts.builder()
                .setExpiration(Date.from(expireTime.toInstant(ZoneOffset.ofHours(8))))
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, GlobalConstants.JWT_KEY.getBytes())
                .compact();
        return jwtToken;
    }

    /**
     * 验证token
     *
     * @params token
     **/
    public static boolean verify(final String token) {
        // 1. 解析
        JwtParser parser = Jwts.parser();
        Claims claims = parser
                .setSigningKey(GlobalConstants.JWT_KEY)
                .parseClaimsJws(token).getBody();
        // 2. 取得过期时间戳
        LocalDateTime expireDate = claims.getExpiration().toInstant()
                .atZone(ZoneId.systemDefault()).toLocalDateTime();
        // 2. 判断
        if (LocalDateTime.now().compareTo(expireDate) > 0) {
            return false;
        }
        return true;
    }
}
