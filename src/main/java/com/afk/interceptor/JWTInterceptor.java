package com.afk.interceptor;

import com.afk.util.TokenUtil;
import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: dengcong
 * @Date: 2022/8/17 - 08 - 17 - 20:21
 * @Description: com.afk.interceptor 使用拦截器进行token验证
 */
@Component
public class JWTInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map<String, Object> map = new HashMap<>();
        // 获取http请求头中的token
        String token = request.getHeader("token");
        try {
            TokenUtil.verifyToken(token);
            return true;
        } catch (SignatureVerificationException e) {
            map.put("message", "签名异常");
        } catch (TokenExpiredException e) {
            map.put("message", "token过期!");
        } catch (InvalidClaimException e) {
            map.put("message", "token无效!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.put("status", false);
        String json = new ObjectMapper().writeValueAsString(map);
        response.setContentType("application/json;charset-utf-8");
        response.getWriter().write(json);
        response.getWriter().println(json);
        return false;
    }
}
