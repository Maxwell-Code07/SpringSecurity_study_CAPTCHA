package com.powernode.springsecurity11.service.impl;

import com.powernode.springsecurity11.dao.SysUserDao;
import com.powernode.springsecurity11.entity.SysUser;
import com.powernode.springsecurity11.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author hzz
 * @Date 2024-02-29 23:47
 */
@Service
@Slf4j
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserDao sysUserDao;

    @Override
    public SysUser getByUserName(String username) {
        return sysUserDao.getByUserName(username);
    }
}
