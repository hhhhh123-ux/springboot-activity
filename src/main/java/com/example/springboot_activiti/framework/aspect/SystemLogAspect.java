package com.example.springboot_activiti.framework.aspect;

import com.alibaba.fastjson.JSONObject;
import com.example.springboot_activiti.common.utils.DateUtils;
import com.example.springboot_activiti.common.utils.ip.AddressUtils;
import com.example.springboot_activiti.common.utils.ip.IpUtils;
import com.example.springboot_activiti.framework.aspect.lang.SystemControllerLog;
import com.example.springboot_activiti.framework.config.SysLogThread;
import com.example.springboot_activiti.framework.security.LoginUser;
import com.example.springboot_activiti.framework.security.service.TokenService;
import com.example.springboot_activiti.project.system.domain.po.SLog;
import com.example.springboot_activiti.project.system.domain.po.SUser;
import com.example.springboot_activiti.project.system.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;


@Aspect
@Component
public class SystemLogAspect {

    private static Logger logger = LoggerFactory.getLogger(SystemLogAspect.class);

    private ThreadLocal<SLog> webLogBeanThreadLocal = new ThreadLocal<>();
    private ThreadLocal<Long> startTimeThreadLocal=new ThreadLocal<>();
    private ThreadLocal<Boolean> isPersistentThreadLocal=new ThreadLocal<>();
    /**
     * 操作数据库
     */
    @Autowired
    private SysLogService addLogService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private WebLogHandler webLogHandler;

    /*定义切点
     *  Controller层切点 注解拦截
     */
    @Pointcut("@annotation(com.example.springboot_activiti.framework.aspect.lang.SystemControllerLog)")
    public void logPointCut() {
    }

    /*切面*/
//    @Around(value = "logPointCut()")
//    public void around(ProceedingJoinPoint joinPoint) {
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        this.HandelLog(joinPoint, request, null);
//    }

    /**
     * 方法正常运行后 执行
     *
     * @param joinPoint 切点
     */
    @AfterReturning(value = "logPointCut()")
    public void AfterReturning(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        this.HandelLog(joinPoint, request, null);
    }

    /**
     * 异常通知
     */
    @AfterThrowing(value = "logPointCut()", throwing = "ex")
    public void AfterThrowing(JoinPoint joinPoint, Throwable ex) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        this.HandelLog(joinPoint, request, ex);
    }

    /**
     * @描述: 处理封装 OperLog
     * @date:
     */

    public void HandelLog(JoinPoint joinPoint, HttpServletRequest request, Throwable e) {
        logger.info("调用日志监控");
        SLog adminLog = new SLog();
        /*从切面值入点获取植入点方法*/
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        /*获取切入点方法*/
        Method method = signature.getMethod();
        /*获取方法上的值*/
        SystemControllerLog systemControllerLog = method.getAnnotation(SystemControllerLog.class);



            long startTime= DateUtils.getNowDate().getTime();
            Date date=new Date(startTime);
            adminLog.setTime(date);

        /*保存操作事件*/
        if (systemControllerLog != null) {
            String operation = systemControllerLog.operation();
            String description = systemControllerLog.description();
            adminLog.setOpermodal(operation);
            /*保存日志模块*/
            adminLog.setOpermodal(operation);
            /*描述功能详情*/
            adminLog.setDescr(description);
            String type = systemControllerLog.type();
            adminLog.setType(type.toString());
            /*打印*/
            logger.info("操作事件 :" + operation);
            logger.info("操作描述 :" + description);
            logger.info("事件类型为:" + type);
        }
        /*获取请求体内容*/

        String requestUri = request.getRequestURI();/*获取请求地址*/
        String requestMethod = request.getMethod();/*获取请求方式*/
        String remoteAddr1 = request.getRemoteAddr();/*获取请求IP*/
        String remoteAddr = IpUtils.getIpAddr(request);
        // String remoteAddr = IpUtils.getLocalIP();
        String userAgent = AddressUtils.userAgent(request);
        /*存请求地址，请求方式，请求IP*/
        adminLog.setHost(remoteAddr);
        adminLog.setIpaddress(AddressUtils.getAddress(remoteAddr));
        logger.info("客户端IP为：" + remoteAddr);
        adminLog.setUrl(requestUri);
        logger.info("请求路径为：" + requestUri);
        adminLog.setMethod(requestMethod);
        logger.info("请求方式为：" + requestMethod);

        logger.info("浏览器:" + userAgent);
        /*获取参数*/
        String params = "";

        Object[] args = joinPoint.getArgs();
        if (args != null) {
            for (Object obj : args) {
                params = obj.toString();
                logger.info("参数为：" + params);
            }
            params = args[0].toString();
            logger.info("请求参数为：" + params);
            /*保存请求参数*/
            adminLog.setParams(params);
        }


        LoginUser loginUser = tokenService.getLoginUser(request);
        if (loginUser != null) {
            SUser user = loginUser.getUser();
            String userName = user.getUserName();
            adminLog.setOperuser(userName);
            logger.info("操作员是" + userName);
            logger.info("操作员Id为" + user.getUserId());
        } else {

            String user = JSONObject.toJSONString(joinPoint.getArgs());
            System.out.println(user.replace("[", "").replace("]", ""));
            JSONObject jsonObject = JSONObject.parseObject(user.replace("[", "").replace("]", ""));
            String username = (jsonObject.get("username")).toString();
            System.out.println(username);
            adminLog.setOperuser(username);
        }
        if (method.isAnnotationPresent(SystemControllerLog.class)) {
            if (e == null) {
                adminLog.setErrormsg("成功");
            } else {
                adminLog.setErrormsg(e.getMessage());
            }

        }
        adminLog.setParams(params);
        logger.info("插入数据");
        webLogHandler.processLog(adminLog);
        logger.info("插入完成");
    }


}
