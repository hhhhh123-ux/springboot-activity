package com.example.springboot_activiti.project.code.mapper;

import com.example.springboot_activiti.project.code.domain.po.SSkuStock;

public interface SSkuStockMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SSkuStock record);

    int insertSelective(SSkuStock record);

    SSkuStock selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SSkuStock record);

    int updateByPrimaryKey(SSkuStock record);
}