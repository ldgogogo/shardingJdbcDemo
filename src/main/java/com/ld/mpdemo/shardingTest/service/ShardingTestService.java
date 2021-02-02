package com.ld.mpdemo.shardingTest.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ld.mpdemo.shardingTest.entity.ShardingTest;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author ld
 * @since 2021-01-23
 */
public interface ShardingTestService extends IService<ShardingTest> {

    List<ShardingTest> shardingTest();
}
