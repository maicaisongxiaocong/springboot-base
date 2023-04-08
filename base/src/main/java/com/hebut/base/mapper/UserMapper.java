package com.hebut.base.mapper;

import com.hebut.base.entity.vo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cxc
 * @since 2023-04-02
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    User getAllUserInfo();

    User findByAccount(@Param("account") int account);
}
