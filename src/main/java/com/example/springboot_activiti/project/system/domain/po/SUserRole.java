package com.example.springboot_activiti.project.system.domain.po;

import java.io.Serializable;
import lombok.Data;

/**
 * s_user_role
 * @author 
 */
@Data
public class SUserRole implements Serializable {
    private Integer id;

    private Integer userId;

    private Integer roleId;

    private static final long serialVersionUID = 1L;
}