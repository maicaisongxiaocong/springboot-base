package com.hebut.base.entity.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author cxc
 * @since 2023-04-02
 */
@ApiModel("登录信息")
@Data
@EqualsAndHashCode(callSuper = false)
public class Login implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
      @ApiModelProperty("用户ID")
      private Integer id;

    /**
     * 名字
     */
    private String name;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱号
     */
    private String email;


}
