package com.ithuangwei.eurekafeignclient.feign;

import org.springframework.stereotype.Component;

/**
 * @author Huangw
 * @projectName workspace_study
 * @description: TODO
 * @date 2019/8/13 16:07
 */
@Component
public class HiHystrix implements EurekaClientFeign{
    @Override
    public String sayHiFromClientEureka(String name) {
        return "hi," + name + ",sorry error!";
    }
}
