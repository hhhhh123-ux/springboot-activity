package com.example.springboot_activiti.framework.security.service;

import com.example.springboot_activiti.common.utils.ServletUtils;
import com.example.springboot_activiti.common.utils.StringUtils;
import com.example.springboot_activiti.framework.security.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("ss")
public class Permission {

    @Autowired
    TokenService tokenService;

    public boolean hasPermission(String permissions) {
        if (StringUtils.isEmpty(permissions)) {
            return false;
        }
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        if (loginUser == null || StringUtils.isEmpty(loginUser.getPermissions())) {
            return false;
        }
        Set<String> authorities = loginUser.getPermissions();
        for (String permission : permissions.split(",")) {
            if (StringUtils.isNotEmpty(permission) && hasPermissions(authorities, permission)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasPermissions(Set<String> authorities, String permission) {
        return authorities.contains("*.*.*") || authorities.contains(permission.trim());
    }
}