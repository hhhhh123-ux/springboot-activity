package com.example.springboot_activiti.project.code.service;

import com.example.springboot_activiti.project.code.domain.dto.Code;
import com.example.springboot_activiti.project.code.domain.po.SSkuStock;

public interface CodeService {
    public SSkuStock query(String id);
}
