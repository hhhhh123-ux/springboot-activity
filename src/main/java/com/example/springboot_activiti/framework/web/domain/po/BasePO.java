package com.example.springboot_activiti.framework.web.domain.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BasePO implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 创建者 */
    private String createby;

    /** 创建者 */
    private String updateby;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatetime;


}
