package com.powernode.springsecurity11.service;

import com.powernode.springsecurity11.entity.SysUser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author hzz
 * @Date 2024-02-29 23:48
 */
@SpringBootTest
class SysUserServiceImplTest {

    @Resource
    private SysUserService sysUserService;

    @Test
    void getByUserName(){
        SysUser sysUser = sysUserService.getByUserName("aa");
        assertNull(sysUser);
    }
}