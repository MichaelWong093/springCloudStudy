package com.ithuangwei.eurekafeignclient.controller;

import com.ithuangwei.eurekafeignclient.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Huangw
 * @projectName workspace_study
 * @description: TODO
 * @date 2019/8/13 14:51
 */
@RestController
public class HiController {

    @Autowired
    HiService hiService;

    @GetMapping("/hi")
    public String sayHi(@RequestParam(defaultValue = "forezp", required = false) String name) {
        return hiService.sayHi(name);
    }
}
