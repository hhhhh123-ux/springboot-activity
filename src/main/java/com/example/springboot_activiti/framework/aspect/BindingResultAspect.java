package com.example.springboot_activiti.framework.aspect;

import com.example.springboot_activiti.framework.web.domain.AjaxResult;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class BindingResultAspect {
    private static Logger logger = LoggerFactory.getLogger(BindingResultAspect.class);

    /*定义切点
     *  Controller层切点 注解拦截
     */
    @Pointcut("@annotation(com.example.springboot_activiti.framework.aspect.lang.BindingResultLog)")
    public void logPointCut() {
    }


    /**
     * 异常通知
     */
    @Around(value = "logPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof BindingResult) {
                BindingResult result = (BindingResult) arg;
                if (result.hasErrors()) {
                    FieldError fieldError = result.getFieldError();
                    if(fieldError!=null){
                        return AjaxResult.error(fieldError.getDefaultMessage());
                    }else{
                        return AjaxResult.error();
                    }
                }
            }
        }
        return joinPoint.proceed();
    }



}
