package com.talenco.tasksystem.controller;

import com.talenco.tasksystem.entity.Result;
import com.talenco.tasksystem.entity.ResultCode;
import com.talenco.tasksystem.exception.ClientException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用于测试
 *
 * @author echcz
 * @date 2019-04-16 22:24:37
 */
@RestController
@RequestMapping("hello")
public class HelloController {
    @PreAuthorize("hasRole('SUPERADMIN')")
    @GetMapping("world")
    public Result<String> world() {
        return new Result<>(ResultCode.OK, "hello world");
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("noworld")
    public Result<String> noWorld() {
        return new Result<>(ResultCode.OK, "No ! hello do not world");
    }

    @GetMapping("error")
    public Result<String> error() {
        if (2 > 1) {
            throw new RuntimeException("error");
        }
        return new Result<>(ResultCode.ERRO, "it is error");
    }

    @GetMapping("clientError")
    public Result<String> clientError() {
        if (2 > 1) {
            throw new ClientException("client error");
        }
        return new Result<>(ResultCode.ERRO, "it is client error");
    }
}
