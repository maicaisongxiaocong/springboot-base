package com.hebut.base.service.impl;

import com.hebut.base.entity.vo.Login;
import com.hebut.base.mapper.LoginMapper;
import com.hebut.base.service.LoginService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cxc
 * @since 2023-04-02
 */
@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper, Login> implements LoginService {

    @Autowired
    LoginMapper loginMapper;

    @Override
    public Login getAll() {

        return loginMapper.getAllLoginInfo();

    }
}
