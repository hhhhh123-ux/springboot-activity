package com.example.springboot_activiti.project.system.mapper;

import com.example.springboot_activiti.project.system.domain.po.SLog;

public interface SLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SLog record);

    int insertSelective(SLog record);

    SLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SLog record);

    int updateByPrimaryKey(SLog record);
}