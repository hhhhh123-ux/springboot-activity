package com.example.springboot_activiti.project.system.service;

import com.example.springboot_activiti.project.system.domain.po.SDept;

import java.util.List;

public interface SysDeptService {
    public List<SDept> selectList(SDept dept);
}
