package com.powernode.springsecurity11.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author hzz
 * @Date 2024-03-01 21:46
 */
public interface SysMenuDao {
    List<String> queryPermissionByUserId(@Param("userId")Integer userId);
}
