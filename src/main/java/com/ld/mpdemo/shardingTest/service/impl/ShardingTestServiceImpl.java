package com.ld.mpdemo.shardingTest.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ld.mpdemo.shardingTest.entity.ShardingTest;
import com.ld.mpdemo.shardingTest.mapper.ShardingTestMapper;
import com.ld.mpdemo.shardingTest.service.ShardingTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ld
 * @since 2021-01-23
 */
@Service
public class ShardingTestServiceImpl extends ServiceImpl<ShardingTestMapper, ShardingTest> implements ShardingTestService {

    @Autowired
    ShardingTestMapper mapper;

    @Override
    @DS("sharding")
    public List<ShardingTest> shardingTest() {
        return mapper.shardingTest();
    }
}
