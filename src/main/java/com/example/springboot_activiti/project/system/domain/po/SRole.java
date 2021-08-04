package com.example.springboot_activiti.project.system.domain.po;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * s_role
 * @author 
 */
@Data
public class SRole implements Serializable {
    private Integer roleId;

    @NotEmpty(message = "角色名称不能为空")
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


    @NotEmpty(message = "请选择菜单权限")
    private List<Integer> menus;

    private static final long serialVersionUID = 1L;
}