package com.ithuangwei.logservice.component;

import cn.hutool.json.JSONUtil;
import com.ithuangwei.logservice.entity.SysLog;
import com.ithuangwei.logservice.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * @author Huangw
 * @projectName workspace_study
 * @description: TODO
 * @date 2019/8/20 10:20
 */
@Component
public class Receiver {

    private CountDownLatch latch = new CountDownLatch(1);
    @Autowired
    SysLogService sysLogService;

    public void receiveMessage(String message) {
        System.out.println("Receive <" + message + ">");
        SysLog sysLog = JSONUtil.toBean(message, SysLog.class);
        sysLogService.saveLogger(sysLog);
        latch.countDown();
    }
}
