package com.talenco.tasksystem.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.talenco.tasksystem.domain.User;
import com.talenco.tasksystem.domain.UserDesc;
import com.talenco.tasksystem.domain.UserKey;
import com.talenco.tasksystem.entity.Result;
import com.talenco.tasksystem.entity.ResultCode;
import com.talenco.tasksystem.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

/**
 * 返回json的登录成功处理器
 * 还会将用户信息存入session
 *
 * @author echcz
 * @date 2019-04-16 23:57:35
 */
@Slf4j
@Component
public class RestAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private UserServiceImpl userServiceImpl;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        MyUserDetails principal = (MyUserDetails) authentication.getPrincipal();
        UserKey userKey = principal.getUserKey();
        if (userKey == null) {
            throw new ServletException("用户登录信息缺失");
        }
        log.info(userKey.getUsername() + "登录成功");
        User user = new User();
        user.setKey(userKey);
        String userDescId = userKey.getUserDescId();
        if (userDescId != null) {
            Optional<UserDesc> userDesc = userServiceImpl.getUserDescById(userDescId);
            user.setDesc(userDesc.orElse(null));
        }
        HttpSession session = httpServletRequest.getSession();
        session.setAttribute("user", user);
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.getWriter().write(objectMapper.writeValueAsString(
                new Result<>(ResultCode.OK, "登录成功")));
    }
}
