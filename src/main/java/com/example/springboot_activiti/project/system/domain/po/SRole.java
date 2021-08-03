package com.example.springboot_activiti.project.system.domain.po;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * s_role
 * @author 
 */
@Data
public class SRole implements Serializable {
    private Integer roleId;

    private String roleName;

    private String roleKey;

    private Integer status;

    private String roleSort;

    private String menuCheckStr;

    private String deptCheckStr;

    private String delFlag;

    private String createby;

    private String updateby;

    private Date createtime;

    private static final long serialVersionUID = 1L;
}