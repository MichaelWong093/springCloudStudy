package com.ithuangwei.eurekaribbonclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Huangw
 * @projectName workspace_study
 * @description: TODO
 * @date 2019/8/13 11:37
 */
@Service
public class RibbonService {

    @Autowired
    private RestTemplate restTemplate;

    public String hi(String name) {
        String url = "http://eureka-client/hi?name=" + name;
        return restTemplate.getForObject(url, String.class);
    }
}
