package com.ld.mpdemo.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author ld
 * @since 2021-01-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId(value = "USER_ID", type = IdType.AUTO)
    private Long userId;

    /**
     * 用户名
     */
    @TableField("USERNAME")
    private String username;

    /**
     * 密码
     */
    @TableField("PASSWORD")
    private String password;

    /**
     * 部门ID
     */
    @TableField("DEPT_ID")
    private Long deptId;

    /**
     * 邮箱
     */
    @TableField("EMAIL")
    private String email;

    /**
     * 联系电话
     */
    @TableField("MOBILE")
    private String mobile;

    /**
     * 状态 0锁定 1有效
     */
    @TableField("STATUS")
    private String status;

    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField("MODIFY_TIME")
    private Date modifyTime;

    /**
     * 最近访问时间
     */
    @TableField("LAST_LOGIN_TIME")
    private Date lastLoginTime;

    /**
     * 性别 0男 1女 2保密
     */
    @TableField("SSEX")
    private String ssex;

    /**
     * 是否开启tab，0关闭 1开启
     */
    @TableField("IS_TAB")
    private String isTab;

    /**
     * 主题
     */
    @TableField("THEME")
    private String theme;

    /**
     * 头像
     */
    @TableField("AVATAR")
    private String avatar;

    /**
     * 描述
     */
    @TableField("DESCRIPTION")
    private String description;

    /**
     * 盐
     */
    @TableField("SALT")
    private String salt;


}
