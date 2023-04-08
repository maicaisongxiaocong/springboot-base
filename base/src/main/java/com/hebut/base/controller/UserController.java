package com.hebut.base.controller;


import com.hebut.base.common.exception.CustomeException;
import com.hebut.base.common.exception.ExceptionEnum;
import com.hebut.base.service.UserService;
import com.hebut.base.util.RedisUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService UserService;

    @Autowired
    private RedisUtils redis;



    /**
     * 登录
     * 转载请注明出处，更多技术文章欢迎大家访问我的个人博客站点：https://www.doufuplus.com
     *
     * @author cxc
     * @date 2023/04/07
     */
    @ApiOperation("登录")
    @PostMapping("/login")
    public String login(String account, String password, HttpServletResponse response) {

        throw new CustomeException(ExceptionEnum.SUCCESS);

    /*    //todo:账号密码从数据库增加，注意密码的加密
        if (!("153084".equals(account) && "153084".equals(password))) {
            return "error";
        }
        return "success";*/
    }

}

