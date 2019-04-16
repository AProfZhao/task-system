package com.talenco.tasksystem.security;

import com.talenco.tasksystem.domain.UserKey;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * 自定义 UserDetails
 * 使用 UserKey信息
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MyUserDetails implements UserDetails {
    private UserKey userKey;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // jdk8新特性，函数式编程，将roles转化为stream再map为SimpleGrantedAuthority再转化为List
        return userKey.getRoles().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return (userKey != null) ? (userKey.getPassword()) : null;
    }

    @Override
    public String getUsername() {
        return (userKey != null) ? (userKey.getUsername()) : null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
