package com.example.springboot_activiti.project.act.mapper;

import com.example.springboot_activiti.project.act.doman.LeaveVo;
import com.example.springboot_activiti.project.act.doman.po.SLeaveform;
import io.lettuce.core.dynamic.annotation.Param;

public interface SLeaveformMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SLeaveform record);

    int insertSelective(SLeaveform record);

    SLeaveform selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SLeaveform record);

    int updateByPrimaryKey(SLeaveform record);

    LeaveVo selectByTask(@Param("processInstanceId")String procinstid,@Param("deptId")String deptId,@Param("area") String area);
}