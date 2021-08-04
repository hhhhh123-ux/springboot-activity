package com.example.springboot_activiti.project.system.service.impl;

import com.example.springboot_activiti.project.system.domain.po.SDept;
import com.example.springboot_activiti.project.system.mapper.SDeptMapper;
import com.example.springboot_activiti.project.system.service.SysDeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysDeptServiceImpl implements SysDeptService {

    @Resource
    private SDeptMapper deptMapper;


    @Override
    public List<SDept> selectList(SDept dept) {

        List<SDept> depts=deptMapper.selectByList(dept);
        return depts;
    }
}
