package com.hebut.base.service.impl;

import com.hebut.base.entity.vo.User;
import com.hebut.base.mapper.UserMapper;
import com.hebut.base.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper UserMapper;

    @Override
    public User getAll() {

        return UserMapper.getAllUserInfo();

    }
}
