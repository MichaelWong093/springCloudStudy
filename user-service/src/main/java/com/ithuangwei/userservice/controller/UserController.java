package com.ithuangwei.userservice.controller;

import com.ithuangwei.userservice.aop.SysLogger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Huangw
 * @projectName workspace_study
 * @description: TODO
 * @date 2019/8/14 14:48
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/hi")
    @SysLogger(value = "login",operation = "你好")
    public String hi() {
        return "I'm forezp";
    }
}
