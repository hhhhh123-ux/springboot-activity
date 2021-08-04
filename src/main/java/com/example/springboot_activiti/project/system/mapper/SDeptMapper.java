package com.example.springboot_activiti.project.system.mapper;

import com.example.springboot_activiti.project.system.domain.po.SDept;

import java.util.List;

public interface SDeptMapper {
    int deleteByPrimaryKey(Integer deptId);

    int insert(SDept record);

    int insertSelective(SDept record);

    SDept selectByPrimaryKey(Integer deptId);

    int updateByPrimaryKeySelective(SDept record);

    int updateByPrimaryKey(SDept record);

    List<SDept> selectByList(SDept record);
}