package com.ithuangwei.eurekafeignclient.feign;

import com.ithuangwei.eurekafeignclient.config.FeignConfig;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Huangw
 * @projectName workspace_study
 * @description: TODO
 * @date 2019/8/13 14:42
 */
@FeignClient(value = "eureka-client",
        configuration = FeignConfig.class,
        fallback = HiHystrix.class)
public interface EurekaClientFeign {

    @GetMapping("/hi")
    String sayHiFromClientEureka(@RequestParam(value = "name") String name);
}
