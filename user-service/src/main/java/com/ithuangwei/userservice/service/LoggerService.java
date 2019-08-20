package com.ithuangwei.userservice.service;

import cn.hutool.json.JSONUtil;
import com.ithuangwei.userservice.config.MqConfig;
import com.ithuangwei.userservice.entity.SysLog;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Huangw
 * @projectName workspace_study
 * @description: TODO
 * @date 2019/8/20 10:44
 */
@Service
public class LoggerService {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void log(SysLog sysLog) {
        rabbitTemplate.convertAndSend(MqConfig.queueName, JSONUtil.toJsonStr(sysLog));
    }
}
