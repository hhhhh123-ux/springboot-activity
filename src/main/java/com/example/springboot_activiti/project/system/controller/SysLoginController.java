package com.example.springboot_activiti.project.system.controller;

import com.example.springboot_activiti.common.exception.user.CodeException;
import com.example.springboot_activiti.framework.security.LoginBody;
import com.example.springboot_activiti.framework.web.domain.AjaxResult;
import com.example.springboot_activiti.project.system.service.SysLoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SysLoginController {



    @Resource
    private SysLoginService loginService;
    /**
     * 登录方法
     *
     * @param loginBody 登录信息
     * @return 结果
     */
    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginBody loginBody) throws CodeException {

        AjaxResult ajax = AjaxResult.success();
        String token = loginService.login(loginBody);
        ajax.put("token", token);
        return ajax;
    }


}
