package com.powernode.springsecurity11.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author hzz
 * @Date 2024-03-01 0:18
 */
@Controller
@Slf4j
@RequestMapping("/student")
public class StudentController {

    // 物理视图 = 默认前缀 + 逻辑视图 + 默认后缀

    @GetMapping("/query")
    @PreAuthorize("hasAuthority('student:query')")
    public String queryInfo(){
        // /templates/student/query.html
        return "student/query";
    }

    @GetMapping("/add")
    @PreAuthorize("hasAuthority('student:add')")
    public String addInfo(){
        return "student/add";
    }

    @GetMapping("/update")
    @PreAuthorize("hasAuthority('student:update')")
    public String updateInfo(){
        return "student/update";
    }

    @GetMapping("/delete")
    @PreAuthorize("hasAuthority('student:delete')")
    public String deleteInfo(){
        return "student/delete";
    }

    @GetMapping("/export")
    @PreAuthorize("hasAuthority('student:export')")
    public String exportInfo(){
        return "student/export";
    }
}
