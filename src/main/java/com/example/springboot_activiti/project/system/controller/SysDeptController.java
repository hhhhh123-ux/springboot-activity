package com.example.springboot_activiti.project.system.controller;

import com.example.springboot_activiti.common.constant.SystemConstant;
import com.example.springboot_activiti.framework.aspect.lang.SystemControllerLog;
import com.example.springboot_activiti.framework.web.controller.BaseController;
import com.example.springboot_activiti.framework.web.page.TableDataInfo;
import com.example.springboot_activiti.project.system.domain.po.SDept;
import com.example.springboot_activiti.project.system.domain.po.SMenu;
import com.example.springboot_activiti.project.system.service.SysDeptService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class SysDeptController extends BaseController {

    @Resource
    private SysDeptService deptService;
    @SystemControllerLog(description = "部门列表",type = SystemConstant.list,operation = "部门模块")
    @PostMapping("/list")
    public TableDataInfo list(@RequestBody SDept dept)
    {

        startPage();
        List<SDept> depts=deptService.selectList(dept);
        return getDataTable(depts);
    }
}
