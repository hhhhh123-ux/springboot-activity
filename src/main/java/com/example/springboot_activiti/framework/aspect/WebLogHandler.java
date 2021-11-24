package com.example.springboot_activiti.framework.aspect;

import com.example.springboot_activiti.project.system.domain.po.SLog;



public interface WebLogHandler {
    /**
     * 处理日志
     * @param t 日志对象
     * @param isPersistent 是否需要持久化 true表示需要持久化、false表示不需要
     * @throws
     */
    void processLog(SLog adminLog) ;

    /**
     * 持久化日志
     * @param
     * @throws
     */
    void persistenceLog(SLog adminLog);

    /**
     * 是否需要持久化日志
     * @param isPersistent true表示需要持久化日志
     * @return boolean true表示持久化日志，false表示不持久化日志
     */
    boolean customerWantsPersistenceLog(boolean isPersistent);

}
