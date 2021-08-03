package com.example.springboot_activiti.project.system.controller;

import com.example.springboot_activiti.common.constant.SystemConstant;
import com.example.springboot_activiti.framework.web.controller.BaseController;
import com.example.springboot_activiti.framework.web.domain.AjaxResult;
import com.example.springboot_activiti.framework.web.page.TableDataInfo;
import com.example.springboot_activiti.project.system.domain.po.SMenu;
import com.example.springboot_activiti.project.system.service.SysMenuService;
import com.example.springboot_activiti.project.system.service.impl.SystemControllerLog;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/sys/menu")
public class SysMenuController extends BaseController {

    @Resource
    private SysMenuService menuService;
    /**
     * 获取菜单列表
     */
    @SystemControllerLog(operation = "菜单模板",type = SystemConstant.list,description="菜单列表")
    @PostMapping("/list")
    public TableDataInfo list(@RequestBody SMenu menu)
    {
        startPage();
        List<SMenu> menus=menuService.selectList(menu);
        return getDataTable(menus);
    }
    /**
     * 获取菜单列表
     */
    @SystemControllerLog(operation = "菜单模板",type =SystemConstant.add,description="增加菜单")
    @PostMapping("/add")
    public AjaxResult add(@RequestBody SMenu menu)
    {
        menuService.add(menu);
        return AjaxResult.success();
    }

    /**
     * 获取菜单下拉树列表
     */
    @GetMapping("/treeselect")
    public AjaxResult treeselect(SMenu menu)
    {
        List<SMenu> menus = menuService.selectList(menu);
        return AjaxResult.success(menuService.buildMenuTreeSelect(menus));
    }


}
