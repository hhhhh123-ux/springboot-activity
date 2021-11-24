package com.example.springboot_activiti.project.system.controller;

import com.example.springboot_activiti.common.constant.SystemConstant;
import com.example.springboot_activiti.framework.aspect.lang.SystemControllerLog;
import com.example.springboot_activiti.framework.security.service.TokenService;
import com.example.springboot_activiti.framework.web.controller.BaseController;
import com.example.springboot_activiti.framework.web.page.TableDataInfo;
import com.example.springboot_activiti.project.system.domain.po.SUser;
import com.example.springboot_activiti.project.system.service.SysUserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 *
 *
 */
@RestController
public class SysUserController extends BaseController {

    @Resource
    private SysUserService userService;

    @Resource
    private TokenService tokenService;
    /**
     * 获取用户列表
     */
    @PreAuthorize("@ss.hasPermission('system:user:list')")
    @SystemControllerLog(description = "用户列表",type = SystemConstant.list,operation = "用户模块")
    @GetMapping("/list")
    public TableDataInfo list(SUser user)
    {
        startPage();
        List<SUser> list = userService.selectUserList(user);
        return getDataTable(list);
    }




}
