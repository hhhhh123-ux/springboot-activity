package com.example.springboot_activiti.project.system.mapper;

import com.example.springboot_activiti.project.system.domain.po.SRoleMenu;

import java.util.List;

public interface SRoleMenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SRoleMenu record);

    int insertSelective(SRoleMenu record);

    SRoleMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SRoleMenu record);

    int updateByPrimaryKey(SRoleMenu record);

    int insertSelectiveByList(List<SRoleMenu> roleMenus);
}