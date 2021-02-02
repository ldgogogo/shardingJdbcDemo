package com.ld.mpdemo.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ld.mpdemo.user.entity.User;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author ld
 * @since 2021-01-26
 */
public interface UserMapper extends BaseMapper<User> {

    List<User> findAll();
}
