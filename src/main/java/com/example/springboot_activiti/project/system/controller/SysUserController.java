package com.example.springboot_activiti.project.system.controller;

import com.example.springboot_activiti.common.constant.SystemConstant;
import com.example.springboot_activiti.framework.security.service.TokenService;
import com.example.springboot_activiti.framework.web.controller.BaseController;
import com.example.springboot_activiti.framework.web.page.TableDataInfo;
import com.example.springboot_activiti.project.system.domain.po.SUser;
import com.example.springboot_activiti.project.system.service.SysUserService;
import com.example.springboot_activiti.project.system.service.impl.SystemControllerLog;
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
    @SystemControllerLog(operation = "用户模板",type= SystemConstant.list,description="用户列表")
    @GetMapping("/list")
    public TableDataInfo list(SUser user)
    {
        startPage();
        List<SUser> list = userService.selectUserList(user);
        return getDataTable(list);
    }




}
