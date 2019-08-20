package com.ithuangwei.logservice.repository;

import com.ithuangwei.logservice.entity.SysLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Huangw
 * @projectName workspace_study
 * @description: TODO
 * @date 2019/8/20 10:34
 */
public interface SysLogDao extends JpaRepository<SysLog,Long> {
}
