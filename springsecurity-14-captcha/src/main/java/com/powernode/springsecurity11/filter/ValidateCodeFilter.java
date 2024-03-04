package com.powernode.springsecurity11.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.thymeleaf.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author hzz
 * @Date 2024-03-03 13:20
 */
@Component
@Slf4j
public class ValidateCodeFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        //TODO 判断路径是否是/login/doLogin，如果不是这个路径，直接放行
        if (!request.getRequestURI().equals("/login/doLogin")) {
            doFilter(request, response, filterChain); // 直接放行
            return;
        }
        // 校验验证码
        vaildateCode(request, response, filterChain);
    }

    private void vaildateCode(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        //TODO 1 从前端获取用户输入的验证码
        String enterCode = request.getParameter("code");
        //TODO 2 从session中获取验证码
        String captchaCodeInsession = (String) request.getSession().getAttribute("CAPTCHA_CODE");
        request.getSession().removeAttribute("captcha_code_error"); // 清除提示信息
        if (StringUtils.isEmpty(enterCode)) {
            request.getSession().setAttribute("captcha_code_error", "请输入验证码");
            response.sendRedirect("/toLogin");
            return;
        }
        if (StringUtils.isEmpty(captchaCodeInsession)) {
            request.getSession().setAttribute("captcha_code_error", "验证码错误");
            response.sendRedirect("/toLogin");
            return;
        }
        //TODO 3 判断二者是否相等
        // 判断两者是否相等
        if (!enterCode.equalsIgnoreCase(captchaCodeInsession)) {
            request.getSession().setAttribute("captcha_code_error", "验证码输入错误");
            response.sendRedirect("/toLogin");
            return;
        }
        request.getSession().removeAttribute("CAPTCHA_CODE"); //删除session中的验证码
        // 程序执行到这里，说明验证码正确
        this.doFilter(request, response, filterChain);
    }
}
