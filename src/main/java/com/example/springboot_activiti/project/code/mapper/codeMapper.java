package com.example.springboot_activiti.project.code.mapper;

import com.example.springboot_activiti.project.code.domain.po.SSkuStock;
import io.lettuce.core.dynamic.annotation.Param;

public interface codeMapper {
    public SSkuStock query(@Param("id") String id, @Param("str")String str);
}
