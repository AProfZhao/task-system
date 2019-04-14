package com.talenco.tasksystem.config;

import com.talenco.tasksystem.security.NoOpPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userKeyService;
    @Autowired
    private AuthenticationSuccessHandler restAuthenticationSuccessHandler;
    @Autowired
    private AuthenticationFailureHandler restAuthenticationFailureHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new NoOpPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userKeyService);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginProcessingUrl("/api/login")
                .successHandler(restAuthenticationSuccessHandler)
                .failureHandler(restAuthenticationFailureHandler)
                .and().authorizeRequests()
                .antMatchers("/api/Login").permitAll()
                .anyRequest()
                .authenticated()
                .and().csrf().disable();
    }

}