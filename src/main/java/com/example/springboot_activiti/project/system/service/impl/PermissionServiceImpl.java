package com.example.springboot_activiti.project.system.service.impl;

import com.example.springboot_activiti.project.system.domain.po.SUser;
import com.example.springboot_activiti.project.system.service.PermissionService;
import com.example.springboot_activiti.project.system.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private SysMenuService menuService;
    @Override
    public Set<String> hasMenuPermission(SUser sUser) {
        Set<String> permission=new HashSet<>();
        permission.addAll(menuService.selectMenuPermsByUserId(sUser.getUserId()));
        return permission;
    }
}
