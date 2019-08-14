package com.ithuangwei.eurekazuulclient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Huangw
 * @projectName workspace_study
 * @description: TODO
 * @date 2019/8/13 9:23
 */
@RestController
public class RestTestController {

    @GetMapping("/testRest")
    public String testRest() {
        String url = "https://www.baidu.com/";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }
}
