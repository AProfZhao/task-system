package com.talenco.tasksystem.component;

import com.talenco.tasksystem.entity.Result;
import com.talenco.tasksystem.entity.ResultCode;
import com.talenco.tasksystem.exception.ClientException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 全局异常处理
 *
 * @author echcz
 * @date 2019-04-17 22:20:19
 */
@Slf4j
@RestControllerAdvice
public class MyExceptionHandler {
    /**
     * 访问被拒异常处理
     * 当客户端访问无权限的端点时会抛出 AccessDeniedException
     */
    @ExceptionHandler(AccessDeniedException.class)
    public void accessDeniedExceptionHandler(HttpServletResponse resp, AccessDeniedException e) throws IOException {
        log.info(e.toString());
        resp.sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
    }

    /**
     * 客户端异常处理
     */
    @ExceptionHandler(ClientException.class)
    public Result<String> clientExceptionHandler(HttpServletResponse resp, ClientException e) {
        log.info(e.toString());
        // 设置http状态码为预期返回的状态码
        resp.setStatus(e.getHttpStatus());
        // 优先设置最外层的message为结果内容
        String msg = e.getMessage();
        // 如果最外层的message为空，则考虑内层的message为结果内容
        if (msg == null) {
            Throwable cause = e.getCause();
            if (cause != null) {
                msg = cause.getMessage();
            }
        }
        return new Result<>(ResultCode.ERRO, msg);
    }

    /**
     * 默认异常处理
     */
    @ExceptionHandler(Exception.class)
    public Result<String> exceptionHandler(HttpServletResponse resp, Exception e) {
        log.info(e.toString());
        resp.setStatus(500);
        return new Result<>(ResultCode.ERRO, e.getMessage());
    }
}
