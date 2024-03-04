package com.powernode.springsecurity11.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author hzz
 * @Date 2024-03-02 19:38
 */
@Controller
@Slf4j
public class LoginController {

    @RequestMapping("/toLogin")
    public String toLogin(){
        // 返回thymeleaf的逻辑视图，物理视图=前缀＋逻辑视图名+后缀
        //  默认前缀：/templates/   默认后缀：.html
        // /templates/ + login + .html
        return "login";
    }
}
