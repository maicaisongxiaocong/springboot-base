package com.hebut.base.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.hebut.base.common.ResultResponse;
import com.hebut.base.entity.vo.User;
import com.hebut.base.service.UserService;
import com.hebut.base.util.RedisUtil;
import com.hebut.base.config.auth.TokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author cxc
 * @since 2023-04-02
 */
@Api("鉴权接口")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService UserService;

    @Autowired
    private RedisUtil redisUtil;


    @ApiOperation("登录")
    @PostMapping("/login")
    @ResponseBody
    public ResultResponse login(String username, String password, HttpServletResponse response) throws JsonProcessingException {
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        //去数据库拿密码验证用户名密码，这里直接验证
        if (username.equals("admin")) {
            if (!password.equals("admin")) {
                return  ResultResponse.error("400", "密码错误");
            }
        } else if (username.equals("user")) {
            if (!password.equals("user")) {
                return ResultResponse.error("400", "密码错误");
            }
        } else {
            return  ResultResponse.error("400", "无此用户");
        }
        Long currentTimeMillis = System.currentTimeMillis();
        String token = TokenUtil.sign(username, currentTimeMillis);
        redisUtil.set(username, currentTimeMillis, TokenUtil.REFRESH_EXPIRE_TIME);
        response.setHeader("Authorization", token);
        response.setHeader("Access-Control-Expose-Headers", "Authorization");

        return ResultResponse.success();
    }

    @ApiOperation("user")
    @PostMapping("/user")
   // @RequiresRoles(logical = Logical.OR,value = {"user","admin"})
    @ResponseBody
    public ResultResponse user(){
        return new ResultResponse("200","成功访问user接口！");
    };

    @ApiOperation("admin")
    @PostMapping("/admin")
  //  @RequiresRoles(logical = Logical.OR,value = {"admin"})
    @ResponseBody
    public Object admin() {
        return new ResultResponse("200","成功访问admin接口！");
    };

}

