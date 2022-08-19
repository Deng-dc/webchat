package com.afk.controller;

import com.afk.enums.ResultEnum;
import com.afk.pojo.User;
import com.afk.response.ResponseMessage;
import com.afk.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: dengcong
 * @Date: 2022/8/17 - 08 - 17 - 19:42
 * @Description: com.afk.controller
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户业务")
public class LoginController {
    @Autowired
    private LoginService loginService;

    /**
     * 用户登录
     * @param user
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "用户登录")
    public ResponseMessage userLogin(@RequestBody User user) {
        String token = loginService.userLogin(user.getUsername(), user.getPassword());
        return ResponseMessage.success(ResultEnum.SUCCESS);
    }
}
