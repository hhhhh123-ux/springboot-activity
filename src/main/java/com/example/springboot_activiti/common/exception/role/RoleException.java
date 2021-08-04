package com.example.springboot_activiti.common.exception.role;

import com.example.springboot_activiti.common.exception.user.UserException;


public class RoleException extends UserException {
    private static final long serialVersionUID = 1L;

    public RoleException(){
        super("role.roleName.error",null);
    }
}
