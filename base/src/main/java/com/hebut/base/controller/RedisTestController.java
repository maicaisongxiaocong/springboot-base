package com.hebut.base.controller;


import com.hebut.base.service.UserService;
import com.hebut.base.util.RedisUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.TimeUnit;

/**
 * @program: base
 * @description: redis使用测试类
 * @author: cxc
 * @create: 2023-04-04 10:41
 **/
@RestController
@Slf4j
@Api("redis测试")
public class RedisTestController {

    @Autowired
    private UserService UserService;
    @Autowired
    private RedisUtils redisUtils;

    @ApiOperation("redis测试")
    @GetMapping("/redisTest/{id}")
    public String hello(@ApiParam("id") @PathVariable(value = "id") String id) {
        //查询缓存中是否存在
        boolean hasKey = redisUtils.exists(id);
        String str = "";
        if (hasKey) {
            //获取缓存
            Object object = redisUtils.get(id);
            log.info("从缓存获取的数据" + object);
            str = object.toString();
        } else {
            //从数据库中获取信息
            log.info("从数据库中获取数据");
            str = UserService.getAll().toString();
            //数据插入缓存（set中的参数含义：key值，user对象，缓存存在时间10（long类型），时间单位）
            redisUtils.set(id, str, 10L, TimeUnit.MINUTES);
            log.info("数据插入缓存" + str);
        }
        return str;
    }
}