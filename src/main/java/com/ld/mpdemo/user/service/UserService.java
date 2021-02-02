package com.ld.mpdemo.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ld.mpdemo.user.entity.User;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author ld
 * @since 2021-01-26
 */
public interface UserService extends IService<User> {

    List<User> findAll_master();

    List<User> findAll_slave();

    List<User> findAll3();

}
