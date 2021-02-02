package com.ld.mpdemo.user.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ld.mpdemo.user.entity.User;
import com.ld.mpdemo.user.mapper.UserMapper;
import com.ld.mpdemo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author ld
 * @since 2021-01-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper mapper;

    @Override
    public List<User> findAll_master() {
        return mapper.findAll();
    }

    @Override
    @DS("slave")
    public List<User> findAll_slave() {
        return mapper.findAll();
    }

    @Override
    @DS("sharding")
    public List<User> findAll3() {
        return null;
    }
}
