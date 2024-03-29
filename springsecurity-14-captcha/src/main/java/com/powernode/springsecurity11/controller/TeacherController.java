package com.powernode.springsecurity11.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author hzz
 * @Date 2024-03-01 0:23
 */
@RestController
@Slf4j
@RequestMapping("/teacher")
public class TeacherController {
    @GetMapping("/query")
    @PreAuthorize("hasAuthority('teacher:query')") // 预授权
    public String queryInfo(){
        return "teacher/query";
    }

}
