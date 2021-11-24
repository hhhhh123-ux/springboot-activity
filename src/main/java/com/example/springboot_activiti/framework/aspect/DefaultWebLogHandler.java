package com.example.springboot_activiti.framework.aspect;

import com.example.springboot_activiti.framework.config.SysLogThread;
import com.example.springboot_activiti.project.system.domain.po.SLog;
import com.example.springboot_activiti.project.system.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;

@Component
public class DefaultWebLogHandler extends AbstractWebLogHandler {

    @Autowired
    SysLogService sysLogService;

    public DefaultWebLogHandler(Executor asyncServiceExecutor) {
        super(asyncServiceExecutor);
    }


    @Override
    public void persistenceLog(SLog adminLog) {
        this.asyncServiceExecutor.execute(new SysLogThread(sysLogService, adminLog));
    }
}
