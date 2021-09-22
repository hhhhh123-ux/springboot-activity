package com.example.springboot_activiti.project.code.mapper;

import com.example.springboot_activiti.project.code.domain.po.SSkuStockBatch;

public interface SSkuStockBatchMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SSkuStockBatch record);

    int insertSelective(SSkuStockBatch record);

    SSkuStockBatch selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SSkuStockBatch record);

    int updateByPrimaryKey(SSkuStockBatch record);
}