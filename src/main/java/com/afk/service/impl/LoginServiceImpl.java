package com.afk.service.impl;

import com.afk.enums.ResultEnum;
import com.afk.exception.BusinessException;
import com.afk.mapper.UserMapper;
import com.afk.pojo.User;
import com.afk.service.LoginService;
import com.afk.util.TokenUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * @Author: dengcong
 * @Date: 2022/8/17 - 08 - 17 - 19:42
 * @Description: com.afk.service.impl
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public String userLogin(String username, String password) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, username);
        User user = userMapper.selectOne(queryWrapper);
        if (user == null) {
            // 用户未注册
            throw new BusinessException(ResultEnum.USER_IS_NOT_REGISTERED);
        }
        if (! user.getPassword().equals( DigestUtils.md5DigestAsHex(password.getBytes())) ) {
            // 密码错误
            throw new BusinessException(ResultEnum.PASSWORD_ERROR);
        }
        return TokenUtil.generateTokenByUsername(username);
    }

    @Override
    public Boolean checkToken(String token) {
        return TokenUtil.verifyToken(token);
    }
}
