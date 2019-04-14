package com.talenco.tasksystem.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.talenco.tasksystem.entity.Result;
import com.talenco.tasksystem.entity.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class RestAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        String ip = httpServletRequest.getRemoteAddr();
        log.info(ip + "登录失败");
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.getWriter().write(objectMapper.writeValueAsString(
                new Result<>(ResultCode.FAIL, e.getMessage())));
    }
}
