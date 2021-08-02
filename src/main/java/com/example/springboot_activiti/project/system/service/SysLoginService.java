package com.example.springboot_activiti.project.system.service;

import com.example.springboot_activiti.common.exception.user.CodeException;
import com.example.springboot_activiti.framework.security.LoginBody;

public interface SysLoginService {

    public String login(LoginBody loginBody) throws CodeException;
}
