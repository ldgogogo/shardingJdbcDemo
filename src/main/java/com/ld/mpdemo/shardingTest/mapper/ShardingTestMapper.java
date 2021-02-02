package com.ld.mpdemo.shardingTest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ld.mpdemo.shardingTest.entity.ShardingTest;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author ld
 * @since 2021-01-23
 */
public interface ShardingTestMapper extends BaseMapper<ShardingTest> {

    List<ShardingTest> shardingTest();
}
