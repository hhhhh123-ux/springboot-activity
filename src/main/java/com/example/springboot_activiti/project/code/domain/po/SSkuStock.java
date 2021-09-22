package com.example.springboot_activiti.project.code.domain.po;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * s_sku_stock
 * @author 
 */
@Data
public class SSkuStock implements Serializable {

    private Integer id;

    private String storeCode;

    private String skuCode;

    private String proStatus;

    private Integer curNumber;

    private static final long serialVersionUID = 1L;

    private List<SSkuStockBatch> batches;
}