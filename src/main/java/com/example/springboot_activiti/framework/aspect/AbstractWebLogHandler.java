package com.example.springboot_activiti.framework.aspect;

import com.example.springboot_activiti.project.system.domain.po.SLog;
import com.example.springboot_activiti.project.system.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.Executor;


public abstract class AbstractWebLogHandler implements WebLogHandler {

    protected Executor asyncServiceExecutor;
    @Autowired
    private volatile SysLogService sysLogService;
    public AbstractWebLogHandler(Executor asyncServiceExecutor) {
        this.asyncServiceExecutor=asyncServiceExecutor;

    }

    /**
     * 处理日志
     * @param
     * @param
     * @throws
     */
    @Override
    public void processLog(SLog adminLog)  {
//        if (customerWantsPersistenceLog(isPersistent)) {
           persistenceLog(adminLog);
//        }
    }

    /**
     * 日志持久化抽象方法，由子类实现
     *
     * @param
     * @throws
     */
    @Override
    public abstract void persistenceLog(SLog adminLog);




    /**
     * 是否需要持久化日志
     * @return boolean true持久化日志，false不持久化日志
     */
    @Override
    public boolean customerWantsPersistenceLog(boolean isPersistent) {
        return isPersistent;
    }

}
