package com.ld.mpdemo.shardingTest.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author ld
 * @since 2021-01-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sharding_test_202012")
public class ShardingTest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private Date date;


}
