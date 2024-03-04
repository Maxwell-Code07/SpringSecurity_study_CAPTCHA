package com.powernode.springsecurity11.vo;

import com.powernode.springsecurity11.entity.SysUser;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @Author hzz
 * @Date 2024-02-29 23:54
 */
// 实现了SpringSecurity的UserDetails接口，UserDetails接口用于表示用户详细信息的核心接口
public class SecurityUser implements UserDetails {

    private final SysUser sysUser;

    // 用来存储权限的List
    private List<SimpleGrantedAuthority> authorityList;

    public SecurityUser(SysUser sysUser){
        this.sysUser = sysUser;
    }

    public void setAuthorityList(List<SimpleGrantedAuthority> authorityList) {
        this.authorityList = authorityList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 没有配置权限
        return authorityList;
    }

    @Override
    public String getPassword() {
        String password = sysUser.getPassword();
        sysUser.setPassword(null); // 擦除我们的密码，防止传到前端
        return password;
    }

    @Override
    public String getUsername() {
        return sysUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return sysUser.getAccountNoExpired().equals(1);
    }

    @Override
    public boolean isAccountNonLocked() {
        return sysUser.getAccountNoLocked().equals(1);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return sysUser.getCredentialsNoExpired().equals(1);
    }

    @Override
    public boolean isEnabled() {
        return sysUser.getEnabled().equals(1);
    }
}

