package com.example.springboot_activiti.framework.security.handle;

import com.example.springboot_activiti.framework.web.domain.AjaxResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class LoginFailureHandlerImpl implements AuthenticationFailureHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        logger.info("登录成功");
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setContentType("application/json;charset=UTF-8");
        if (exception instanceof AuthenticationException) {
            response.getWriter().write(objectMapper.writeValueAsString(((AuthenticationException) exception)));
        } else {
            AjaxResult webResponse = AjaxResult.error("登录信息失效：" + exception.getMessage());
            response.getWriter().write(objectMapper.writeValueAsString(webResponse));
        }
        exception.printStackTrace();
    }
}
