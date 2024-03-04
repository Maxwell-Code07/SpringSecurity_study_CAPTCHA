package com.powernode.springsecurity11.dao;

import com.powernode.springsecurity11.entity.SysUser;
import org.apache.ibatis.annotations.Param;

/**
@Author hzz
@Date 2024-02-29 22:57
*/
public interface SysUserDao {

    /**
     * 根据用户名获取用户信息
     */
    SysUser getByUserName(@Param("userName") String username);
}