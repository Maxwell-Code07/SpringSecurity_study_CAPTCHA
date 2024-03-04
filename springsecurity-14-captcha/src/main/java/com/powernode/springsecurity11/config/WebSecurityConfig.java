package com.powernode.springsecurity11.config;

import com.powernode.springsecurity11.filter.ValidateCodeFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

/**
 * @Author hzz
 * @Date 2024-03-01 0:14
 */
@Configuration
// 开启全局方法安全
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Slf4j
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private ValidateCodeFilter validateCodeFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 在用户名密码认证过滤器之前添加图片验证码过滤器
        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class);

        //authorizeRequests()它开始配置授权规则
        //anyRequest()表示‘任何请求’
        //authenticated()表示只有经过身份验证的，才能访问这些请求
        http.authorizeRequests()
                .mvcMatchers("/code/image")
                .permitAll() // 放开验证码的请求
                .anyRequest()
                .authenticated();
        http.formLogin()
                .loginPage("/toLogin") // 配置登录页面
                .usernameParameter("uname") // 用户名参数
                .passwordParameter("pwd") // 密码参数
                .loginProcessingUrl("/login/doLogin") // 单击登录后进入url
                .failureForwardUrl("/toLogin") // 登录失败
                .successForwardUrl("/index/toIndex") // 登录成功
                .permitAll(); // 配置登录
        http.logout().logoutSuccessUrl("/toLogin"); // 配置退出成功登录页面

        http.csrf().disable(); // 关闭跨域请求保护
    }
}
