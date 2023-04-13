package com.hebut.base.config.auth;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @program: base
 * @description: 配置token实体bean进行拓展，使其适应shiro框架
 * @author: cxc
 * @create: 2023-04-13 10:37
 **/

public class JWTToken implements AuthenticationToken {
    private String token;

    public JWTToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
