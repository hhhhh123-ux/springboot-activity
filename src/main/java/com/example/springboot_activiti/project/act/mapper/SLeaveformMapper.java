package com.example.springboot_activiti.project.act.mapper;

import com.example.springboot_activiti.project.act.doman.SLeaveform;

public interface SLeaveformMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SLeaveform record);

    int insertSelective(SLeaveform record);

    SLeaveform selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SLeaveform record);

    int updateByPrimaryKey(SLeaveform record);
}