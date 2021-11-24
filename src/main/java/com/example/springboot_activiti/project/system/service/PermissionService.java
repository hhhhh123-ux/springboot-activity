package com.example.springboot_activiti.project.system.service;

import com.example.springboot_activiti.project.system.domain.po.SUser;

import java.util.Set;

public interface PermissionService {



    public Set<String> hasMenuPermission(SUser sUser);
}
