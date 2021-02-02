package com.ld.mpdemo.shardingTest.controller;


import com.ld.mpdemo.shardingTest.entity.ShardingTest;
import com.ld.mpdemo.shardingTest.service.ShardingTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ld
 * @since 2021-01-23
 */
@RestController
@RequestMapping("/shardingTest")
public class ShardingTestController {

    @Autowired
    ShardingTestService service;

    @GetMapping(value = "/test1")
    @ResponseBody
    public List<ShardingTest> shardingTest() {
        return service.shardingTest();
    }

}

