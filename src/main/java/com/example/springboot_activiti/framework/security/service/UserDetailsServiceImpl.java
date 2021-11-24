package com.example.springboot_activiti.framework.security.service;

import com.example.springboot_activiti.common.exception.BaseException;
import com.example.springboot_activiti.framework.security.LoginUser;
import com.example.springboot_activiti.project.system.domain.po.SDept;
import com.example.springboot_activiti.project.system.domain.po.SUser;
import com.example.springboot_activiti.project.system.mapper.SDeptMapper;
import com.example.springboot_activiti.project.system.mapper.SUserMapper;
import com.example.springboot_activiti.project.system.service.PermissionService;
import com.example.springboot_activiti.project.system.service.SysUserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import sun.net.ftp.FtpDirEntry;

import javax.annotation.Resource;

@Configuration
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    @Resource
    private SysUserService userService;
    @Autowired
    private PermissionService permissionService;
    @Resource
    private SDeptMapper deptMapper;
    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SUser sUser=userService.selectByUserName(username);
        if(sUser.getDeptId()!=null){
            sUser.setDept(deptMapper.selectByPrimaryKey(sUser.getDeptId()));
        }

        if(sUser==null){
            throw new BaseException("未注册账号");
        }
        return createToken(sUser);
    }

    public UserDetails createToken(SUser sUser){

        return new LoginUser(sUser,permissionService.hasMenuPermission(sUser));
    }
}
