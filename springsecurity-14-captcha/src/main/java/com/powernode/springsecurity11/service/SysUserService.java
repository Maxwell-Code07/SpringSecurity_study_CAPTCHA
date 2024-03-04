package com.powernode.springsecurity11.service;

import com.powernode.springsecurity11.entity.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * @Author hzz
 * @Date 2024-02-29 23:46
 */
public interface SysUserService {

    /**
     * 根据用户名获取用户信息
     */
    SysUser getByUserName(String username);
}
