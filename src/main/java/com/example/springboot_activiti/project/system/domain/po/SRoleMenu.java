package com.example.springboot_activiti.project.system.domain.po;

import java.io.Serializable;
import lombok.Data;

/**
 * s_role_menu
 * @author 
 */
@Data
public class SRoleMenu implements Serializable {
    private Integer id;

    private Integer roleId;

    private Integer menuId;

    private static final long serialVersionUID = 1L;
}