package com.talenco.tasksystem.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.talenco.tasksystem.domain.User;
import com.talenco.tasksystem.domain.UserDesc;
import com.talenco.tasksystem.domain.UserKey;
import com.talenco.tasksystem.entity.Result;
import com.talenco.tasksystem.entity.ResultCode;
import com.talenco.tasksystem.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@Slf4j
@Component
public class RestAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private UserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        UserKey principal = (UserKey) authentication.getPrincipal();
        log.info(principal.getUsername() + "登录成功");
        if (principal.getUserDescId() != null) {
            Optional<UserDesc> userDesc = userService.findUserDescById(principal.getUserDescId());
            User user = new User();
            user.setKey(principal);
            user.setDesc(userDesc.orElse(null));
            httpServletRequest.getSession().setAttribute("user", user);
        }
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.getWriter().write(objectMapper.writeValueAsString(
                new Result<String>(ResultCode.OK, "登录成功")));
    }
}
