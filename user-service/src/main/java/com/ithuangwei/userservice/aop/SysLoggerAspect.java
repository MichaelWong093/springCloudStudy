package com.ithuangwei.userservice.aop;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.ithuangwei.userservice.entity.SysLog;
import com.ithuangwei.userservice.service.LoggerService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author Huangw
 * @projectName workspace_study
 * @description: TODO
 * @date 2019/8/20 10:51
 */
@Aspect
@Component
public class SysLoggerAspect {

    @Autowired
    private LoggerService loggerService;

    @Pointcut("@annotation(com.ithuangwei.userservice.aop.SysLogger)")
    public void loggerPointCut() {
    }

    @Before("loggerPointCut()")
    public void saveLog(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SysLog sysLog = new SysLog();
        SysLogger sysLogger = method.getAnnotation(SysLogger.class);
        if (sysLogger == null) {
            sysLog.setOperation(sysLogger.value());
        } else {
            sysLog.setOperation(sysLogger.operation());
        }
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLog.setMethod(className+"."+methodName+"()");
        //请求参数
        Object[] args = joinPoint.getArgs();
        String params = "";
        for (Object o : args) {
            params += JSONUtil.toJsonPrettyStr(o);
        }
        if (StrUtil.isNotEmpty(params)) {
            sysLog.setParams(params);
        }
        sysLog.setCreateDate(new Date());
        loggerService.log(sysLog);
    }
}
