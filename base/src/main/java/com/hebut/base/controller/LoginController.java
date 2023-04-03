package com.hebut.base.controller;


import com.hebut.base.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cxc
 * @since 2023-04-02
 */
@Api("鉴权接口")
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @ApiOperation("登录")
    @GetMapping("/getAll")
    public String login() {
        return loginService.getAll().toString();
    }

}

