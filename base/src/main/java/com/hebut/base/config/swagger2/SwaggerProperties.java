package com.hebut.base.config.swagger2;

/**
 * @program: base
 * @description: swagger参数
 * @author: cxc
 * @create: 2023-04-07 21:34
 **/

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "swagger")
public class SwaggerProperties {
    // 是否启用Swagger
    private boolean enable;

    // 扫描的基本包
    @Value("${swagger.base.package}")
    private String basePackage;

    // 联系人邮箱
    @Value("${swagger.contact.email}")
    private String contactEmail;

    // 联系人名称
    @Value("${swagger.contact.name}")
    private String contactName;

    // 联系人网址
    @Value("${swagger.contact.url}")
    private String contactUrl;

    // 描述
    @Value("${swagger.description}")
    private String description;

    // 标题
    @Value("${swagger.title}")
    private String title;

    // 网址
    @Value("${swagger.url}")
    private String url;

    // 版本
    @Value("${swagger.version}")
    private String version;
}
