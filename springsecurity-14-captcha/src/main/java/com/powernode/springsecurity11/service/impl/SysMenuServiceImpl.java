package com.powernode.springsecurity11.service.impl;

import com.powernode.springsecurity11.dao.SysMenuDao;
import com.powernode.springsecurity11.entity.SysMenu;
import com.powernode.springsecurity11.service.SysMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author hzz
 * @Date 2024-03-01 22:33
 */
@Service
@Slf4j
public class SysMenuServiceImpl implements SysMenuService {

    @Resource
    private SysMenuDao sysMenuDao;

    @Override
    public List<String> queryPermissionByUserId(Integer userId) {
        return sysMenuDao.queryPermissionByUserId(userId);
    }
}
