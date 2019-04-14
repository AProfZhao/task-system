package com.talenco.tasksystem.controller;

import com.talenco.tasksystem.entity.Result;
import com.talenco.tasksystem.entity.ResultCode;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {
    @PreAuthorize("hasRole('SUPERADMIN')")
    @GetMapping("world")
    private Result<String> world() {
        return new Result<>(ResultCode.OK, "hello world");
    }


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("noworld")
    private Result<String> noWorld() {
        return new Result<>(ResultCode.OK, "No ! hello do not world");
    }
}
