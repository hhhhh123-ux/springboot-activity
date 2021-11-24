package com.example.springboot_activiti.project.system.mapper;

import com.example.springboot_activiti.project.system.domain.po.SMenu;

import java.util.List;

public interface SMenuMapper {
    int deleteByPrimaryKey(Integer menuId);

    int insert(SMenu record);

    int insertSelective(SMenu record);

    SMenu selectByPrimaryKey(Integer menuId);

    int updateByPrimaryKeySelective(SMenu record);

    int updateByPrimaryKey(SMenu record);

     List<SMenu> selectList(SMenu menu);

    public List<String> selectMenuPermsByUserId(Integer userId);
}