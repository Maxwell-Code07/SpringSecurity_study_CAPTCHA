package com.powernode.springsecurity11.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author hzz
 * @Date 2024-03-02 20:32
 */
@Controller
@Slf4j
@RequestMapping("/index")
public class indexController {
    @RequestMapping("/toIndex")
    public String toIndex(){
        return "main";
    }
}
