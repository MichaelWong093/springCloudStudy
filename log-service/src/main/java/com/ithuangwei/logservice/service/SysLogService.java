package com.ithuangwei.logservice.service;

import com.ithuangwei.logservice.entity.SysLog;
import com.ithuangwei.logservice.repository.SysLogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Huangw
 * @projectName workspace_study
 * @description: TODO
 * @date 2019/8/20 10:33
 */
@Service
public class SysLogService {

    @Autowired
    private SysLogDao sysLogDao;

    public void saveLogger(SysLog sysLog) {
        sysLogDao.save(sysLog);
    }

}
