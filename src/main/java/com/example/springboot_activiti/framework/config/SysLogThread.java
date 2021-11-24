package com.example.springboot_activiti.framework.config;


import com.alibaba.fastjson.JSON;
import com.example.springboot_activiti.project.system.domain.po.SLog;
import com.example.springboot_activiti.project.system.service.SysLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SysLogThread implements Runnable {
    private static Logger logger= LoggerFactory.getLogger(SysLogThread.class);
    private volatile SysLogService sysLogService;
    private volatile SLog adminLog;

    public SysLogThread(SysLogService sysLogService,
                        SLog adminLog) {
        this.sysLogService=sysLogService;
        this.adminLog=adminLog;
    }
    @Override
    public void run() {
        try {
            if (logger.isInfoEnabled()) {
                logger.info("thread name " + Thread.currentThread().getName() + " start save operateLog " + JSON.toJSONString(adminLog));
            }
            Thread.sleep(10);
            this.sysLogService.addLog(adminLog);
            if (logger.isInfoEnabled()) {
                logger.info("thread name " + Thread.currentThread().getName() + "save operateLog success ");
            }
        } catch (Exception e) {
            logger.error("thread name "+Thread.currentThread().getName()+" save operateLog error",e);
        }
    }
}
