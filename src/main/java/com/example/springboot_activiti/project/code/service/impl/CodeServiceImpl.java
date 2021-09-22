package com.example.springboot_activiti.project.code.service.impl;

import com.example.springboot_activiti.project.code.domain.po.SSkuStock;
import com.example.springboot_activiti.project.code.mapper.codeMapper;
import com.example.springboot_activiti.project.code.service.CodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CodeServiceImpl implements CodeService {

    @Autowired
    private com.example.springboot_activiti.project.code.mapper.codeMapper codeMapper;

    @Override
    public SSkuStock query(String id) {
        String str="";
        return codeMapper.query(id,str);
    }
}
