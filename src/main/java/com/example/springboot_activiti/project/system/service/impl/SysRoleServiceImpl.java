package com.example.springboot_activiti.project.system.service.impl;

import com.example.springboot_activiti.common.exception.role.RoleException;
import com.example.springboot_activiti.project.system.domain.po.SMenu;
import com.example.springboot_activiti.project.system.domain.po.SRole;
import com.example.springboot_activiti.project.system.domain.po.SRoleMenu;
import com.example.springboot_activiti.project.system.mapper.SMenuMapper;
import com.example.springboot_activiti.project.system.mapper.SRoleMapper;
import com.example.springboot_activiti.project.system.mapper.SRoleMenuMapper;
import com.example.springboot_activiti.project.system.service.SysRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Resource
    private SRoleMapper roleMapper;

    @Resource
    private SRoleMenuMapper roleMenuMapper;

    @Transactional
    @Override
    public void add(SRole role) {
        role.getRoleName();
        //先判断角色名称是否唯一
        selectByRoleName(role.getRoleName());
        //
        roleMapper.insertSelective(role);
        //批量插入
        roleMenuMapper.insertSelectiveByList(getList(role,role.getMenus()));

    }


    public String selectByRoleName(String roleName) {
        List<SRole> list = roleMapper.selectByRoleName(roleName);
        if (list != null && list.size() > 0) {
            throw new RoleException();
        }
        ;
        return "";
    }

    public List<SRoleMenu> getList(SRole role,List<Integer> menus) {
        List<SRoleMenu> roleMenus=new ArrayList<>();
        for(Integer id:menus){
            SRoleMenu roleMenu=new SRoleMenu();
            roleMenu.setRoleId(role.getRoleId());
            roleMenu.setMenuId(id);
            roleMenus.add(roleMenu);
        }
        return roleMenus;
    }
}
