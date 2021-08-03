package com.example.springboot_activiti.project.system.mapper;

import com.example.springboot_activiti.project.system.domain.po.SUserRole;

public interface SUserRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SUserRole record);

    int insertSelective(SUserRole record);

    SUserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SUserRole record);

    int updateByPrimaryKey(SUserRole record);
}