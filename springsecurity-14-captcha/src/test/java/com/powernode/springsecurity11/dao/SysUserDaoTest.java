package com.powernode.springsecurity11.dao;

import com.powernode.springsecurity11.entity.SysUser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author hzz
 * @Date 2024-02-29 23:35
 */
@SpringBootTest
class SysUserDaoTest {

    @Resource
    private SysUserDao sysUserDao;

    @Test
    void getByUserName(){
        SysUser eric = sysUserDao.getByUserName("eric");
        assertNotNull(eric);
    }


}