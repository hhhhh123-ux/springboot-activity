package com.example.springboot_activiti.project.code.domain.po;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * s_sku_stock_batch
 * @author 
 */
@Data
public class SSkuStockBatch implements Serializable {
    private Integer id;

    private String storeCode;

    private String skuCode;

    private String providerCode;

    private Integer batchNumber;

    private BigDecimal price;

    private Integer curNumber;

    private static final long serialVersionUID = 1L;
}