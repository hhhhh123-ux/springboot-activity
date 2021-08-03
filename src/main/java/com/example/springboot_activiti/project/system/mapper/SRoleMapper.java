package com.example.springboot_activiti.project.system.mapper;

import com.example.springboot_activiti.project.system.domain.po.SRole;

public interface SRoleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(SRole record);

    int insertSelective(SRole record);

    SRole selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(SRole record);

    int updateByPrimaryKey(SRole record);
}