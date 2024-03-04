package com.powernode.springsecurity11.dao;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author hzz
 * @Date 2024-03-01 22:27
 */
@SpringBootTest
class SysMenuDaoTest {

    @Resource
    private SysMenuDao sysMenuDao;

    @Test
    void queryPermissionByUserId(){

        List<String> resultList = sysMenuDao.queryPermissionByUserId(1);
        assertTrue(!resultList.isEmpty()); // 判断list不为空
    }
}