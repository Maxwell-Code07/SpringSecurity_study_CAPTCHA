package com.powernode.springsecurity11.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author hzz
 * @Date 2024-03-01 22:32
 */

public interface SysMenuService {
    List<String> queryPermissionByUserId(@Param("userId")Integer userId);
}
