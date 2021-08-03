package com.example.springboot_activiti.project.system.service.impl;

import com.example.springboot_activiti.project.system.domain.po.SLog;
import com.example.springboot_activiti.project.system.mapper.SLogMapper;
import com.example.springboot_activiti.project.system.service.SysLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysLogServiceImpl implements SysLogService {

    @Resource
    private SLogMapper logMapper;
    @Override
    public void addLog(SLog log) {
        logMapper.insertSelective(log);
    }
}
