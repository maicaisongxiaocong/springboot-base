package com.hebut.base.config.redis;

/**
 * @program: base
 * @description: redis配置类
 * @author: cxc
 * @create: 2023-04-04 10:38
 **/
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Configuration
public class RedisConfig{

    @Resource
    private RedisTemplate redisTemplate;

    @PostConstruct
    public void init(){
        RedisSerializer stringSerializer = redisTemplate.getStringSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
    }
/*

    */
/*
    * 解决com.hebut.base.config.auth.ShiroConfig.java ;
    * 函数getManager(UserRealm userRealm, RedisTemplate<String,Object> template)
    * RedisTemplate<String,Object> template 找不到bean问题
    *//*

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }
*/

}

