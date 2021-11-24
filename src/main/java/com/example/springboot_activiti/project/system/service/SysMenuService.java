package com.example.springboot_activiti.project.system.service;

import com.example.springboot_activiti.framework.web.domain.TreeSelect;
import com.example.springboot_activiti.project.system.domain.po.SMenu;

import java.util.List;
import java.util.Set;

public interface SysMenuService {
    public List<SMenu> selectList(SMenu menu);

    public void add(SMenu menu);


    /**
     * 构建前端所需要下拉树结构
     *
     * @param menus 菜单列表
     * @return 下拉树结构列表
     */
    public List<TreeSelect> buildMenuTreeSelect(List<SMenu> menus);

    public Set<String> selectMenuPermsByUserId(Integer userId);

}
