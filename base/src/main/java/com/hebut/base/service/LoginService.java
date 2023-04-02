package com.hebut.base.service;

import com.hebut.base.entity.vo.Login;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cxc
 * @since 2023-04-02
 */
public interface LoginService extends IService<Login> {
    Login getAll();
}
