package com.talenco.tasksystem.security;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 不对密码进行加密处理的密码编码器
 *
 * @author echcz
 * @date 2019-04-16 23:55:25
 */
public class NoOpPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return rawPassword.equals(encodedPassword);
    }
}
