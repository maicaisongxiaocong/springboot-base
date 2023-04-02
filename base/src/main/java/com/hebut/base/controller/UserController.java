package com.hebut.base.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: base
 * @description: 用户管理模块
 * @author: cxc
 * @create: 2023-04-02 15:04
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/login")
    public String login() {
        return "hello world";
    }
}
