package com.example.springboot_activiti.project.system.service.impl;

import com.example.springboot_activiti.project.system.domain.po.SUser;
import com.example.springboot_activiti.project.system.mapper.SUserMapper;
import com.example.springboot_activiti.project.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    @Resource
    private SUserMapper userMapper;
    @Override
    public SUser selectByUserName(String username) {
        return userMapper.selectByUserName(username);
    }

    @Override
    public List<SUser> selectUserList(SUser user) {
        return userMapper.selectUserList(user);
    }
}
