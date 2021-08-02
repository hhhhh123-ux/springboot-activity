package com.example.springboot_activiti.framework.security;

import lombok.Data;

@Data
public class LoginBody {

    private String username;

    private String password;

    private String code;

    private String uuid;

}
