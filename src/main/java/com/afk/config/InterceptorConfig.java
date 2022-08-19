package com.afk.config;

import com.afk.interceptor.JWTInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: dengcong
 * @Date: 2022/8/17 - 08 - 17 - 20:35
 * @Description: com.afk.config 配置拦截器
 */
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInterceptor())
                .addPathPatterns("/**") //拦截所有请求路径
                .excludePathPatterns("/user/login");    //  排除/user/login登录请求
    }
}
