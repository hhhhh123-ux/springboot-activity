package com.example.springboot_activiti.project.system.controller;

import com.example.springboot_activiti.common.constant.SystemConstant;
import com.example.springboot_activiti.framework.aspect.lang.BindingResultLog;
import com.example.springboot_activiti.framework.aspect.lang.SystemControllerLog;
import com.example.springboot_activiti.framework.web.domain.AjaxResult;
import com.example.springboot_activiti.project.system.domain.po.SRole;
import com.example.springboot_activiti.project.system.service.SysRoleService;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/sys/role")
public class SysRoleController {

    @Resource
    private SysRoleService roleService;

    /**
     * 增加角色
     */
    @SystemControllerLog(description = "增加角色", type = SystemConstant.add, operation = "角色模块")
    @PostMapping("/add")
    @BindingResultLog
    public AjaxResult add(@Validated @RequestBody SRole role,BindingResult result) {
            roleService.add(role);
            return AjaxResult.success();
        }

}
