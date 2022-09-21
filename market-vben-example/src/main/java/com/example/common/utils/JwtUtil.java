package com.example.common.utils;

import com.example.common.constants.GlobalConstants;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Map;

/**
 * @author jhlz
 * @time 2022/9/7 23:03
 * @desc: JwtUtil
 */
public class JwtUtil {

    /**
     * 创建 token
     *
     * @param claims
     * @return
     */
    public static String createToken(Map<String, Object> claims) {
        String jwtToken = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, GlobalConstants.JWT_KEY.getBytes()).compact();
        return jwtToken;
    }
}
