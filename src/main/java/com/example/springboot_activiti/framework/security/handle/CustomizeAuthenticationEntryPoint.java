package com.example.springboot_activiti.framework.security.handle;

import com.example.springboot_activiti.framework.web.domain.AjaxResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

@Configuration
public class CustomizeAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

    @Resource
    private ObjectMapper objectMapper;
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        AjaxResult webResponse = AjaxResult.error("请求访问：{}，认证失败，无法访问系统资源");
        httpServletResponse.getWriter().write(objectMapper.writeValueAsString(webResponse));
    }
}
