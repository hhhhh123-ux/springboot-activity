package com.example.springboot_activiti.project.system.domain.po;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * s_dept
 * @author 
 */
@Data
public class SDept implements Serializable {
    private Integer deptId;

    private String deptName;

    private Integer parentId;

    private String status;

    private Integer orderNum;

    private String createby;

    private String updateby;

    private Date createtime;

    private String shen;

    private static final long serialVersionUID = 1L;
}