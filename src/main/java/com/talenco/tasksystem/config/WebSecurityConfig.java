package com.talenco.tasksystem.config;

import com.talenco.tasksystem.security.NoOpPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

/**
 * Spring Security 配置类
 *
 * @author echcz
 * @date 2019-04-16 22:24:00
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    @Qualifier("myUserDetailsService")
    private UserDetailsService userDetailsService;
    @Autowired
    @Qualifier("restAuthenticationSuccessHandler")
    private AuthenticationSuccessHandler authenticationSuccessHandler;
    @Autowired
    @Qualifier("restAuthenticationFailureHandler")
    private AuthenticationFailureHandler authenticationFailureHandler;
    @Autowired
    @Qualifier("restLogoutSuccessHandler")
    private LogoutSuccessHandler logoutSuccessHandler;
    @Autowired
    @Qualifier("restAuthenticationEntryPoint")
    private AuthenticationEntryPoint authenticationEntryPoint;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new NoOpPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .exceptionHandling()
                    .authenticationEntryPoint(authenticationEntryPoint)
                .and().formLogin()
                    .loginProcessingUrl("/login")
                    .successHandler(authenticationSuccessHandler)
                    .failureHandler(authenticationFailureHandler)
                .and().authorizeRequests()
                    .antMatchers("/login").permitAll()
                    .antMatchers("/*.*").permitAll()
                    .antMatchers("/static/**").permitAll()
                    .antMatchers("/test/**").permitAll() // 仅开发与测试环境下使用
                    .anyRequest()
                    .authenticated()
                .and().logout()
                    .logoutSuccessHandler(logoutSuccessHandler)
                .and().csrf()
                    .disable();
    }

}