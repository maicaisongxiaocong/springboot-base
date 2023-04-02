package com.hebut.base.mapper;

import com.hebut.base.entity.vo.Login;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cxc
 * @since 2023-04-02
 */
@Mapper
public interface LoginMapper extends BaseMapper<Login> {
    Login getAllLoginInfo();
}
