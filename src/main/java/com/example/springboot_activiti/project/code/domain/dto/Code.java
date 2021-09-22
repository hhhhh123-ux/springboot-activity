package com.example.springboot_activiti.project.code.domain.dto;

import com.example.springboot_activiti.project.code.domain.po.SSkuStock;
import com.example.springboot_activiti.project.code.domain.po.SSkuStockBatch;
import lombok.Data;

import java.util.List;
@Data
public class Code {
    private SSkuStock sSkuStock;
    private List<SSkuStockBatch> batches;
}
