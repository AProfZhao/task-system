package com.talenco.tasksystem.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.talenco.tasksystem.domain.UserKey;
import com.talenco.tasksystem.entity.Result;
import com.talenco.tasksystem.entity.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登出成功处理器
 *
 * @author echcz
 * @date 2019-04-17 22:26:37
 */
@Slf4j
@Component
public class RestLogoutSuccessHandler implements LogoutSuccessHandler {
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        if (authentication == null) {
            httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        MyUserDetails principal = (MyUserDetails) authentication.getPrincipal();
        UserKey userKey = principal.getUserKey();
        if (userKey == null) {
            throw new ServletException("用户登录信息缺失");
        }
        log.info(userKey.getUsername() + "登出成功");
        HttpSession session = httpServletRequest.getSession();
        session.removeAttribute("user");
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.getWriter().write(objectMapper.writeValueAsString(
                new Result<>(ResultCode.OK, "登出成功")));
    }
}
