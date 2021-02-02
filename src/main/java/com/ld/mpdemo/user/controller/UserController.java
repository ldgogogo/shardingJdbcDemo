package com.ld.mpdemo.user.controller;


import com.ld.mpdemo.user.entity.User;
import com.ld.mpdemo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author ld
 * @since 2021-01-26
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping(value = "/findAll_master")
    @ResponseBody
    public List<User> findAll_master() {
        List<User> users = service.findAll_master();
        return users;
    }

    @GetMapping(value = "/findAll_slave")
    @ResponseBody
    public List<User> findAll_slave() {
        List<User> users = service.findAll_slave();
        return users;
    }

    @GetMapping(value = "/findAll3")
    @ResponseBody
    public List<User> findAll3() {
        List<User> users = service.findAll3();
        return users;
    }
}

