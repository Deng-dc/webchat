package com.afk.service;

/**
 * @Author: dengcong
 * @Date: 2022/8/17 - 08 - 17 - 19:42
 * @Description: com.afk.service
 */
public interface LoginService {
    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    String userLogin(String username, String password);

    /**
     * 校验token
     * @param token
     * @return
     */
    Boolean checkToken(String token);
}
