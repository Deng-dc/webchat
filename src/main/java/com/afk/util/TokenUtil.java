package com.afk.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: dengcong
 * @Date: 2022/8/17 - 08 - 17 - 19:15
 * @Description: com.afk.util
 */
public class TokenUtil {
    private static final String ENCRYPT_KEY = "WebChat";

    public static String generateTokenByUsername(String username) {
        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        long currentTime = System.currentTimeMillis();
        String token = JWT.create()
                .withHeader(map)
                .withClaim("username", username)
                .withIssuedAt(new Date(currentTime))
                .withExpiresAt(new Date(currentTime + 30 * 1000 * 60))
                .sign(Algorithm.HMAC256(TokenUtil.ENCRYPT_KEY));
        return token;
    }

    public static Boolean verifyToken(String token) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(TokenUtil.ENCRYPT_KEY)).build();
        try {
            verifier.verify(token);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
