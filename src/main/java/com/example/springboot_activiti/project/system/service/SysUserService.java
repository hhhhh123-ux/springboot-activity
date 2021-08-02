package com.example.springboot_activiti.project.system.service;

import com.example.springboot_activiti.project.system.domain.po.SUser;

import java.util.List;

public interface SysUserService {
    SUser selectByUserName(String username);


    /**
     * 根据条件分页查询用户列表
     *
     * @param user 用户信息
     * @return 用户信息集合信息
     */
    public List<SUser> selectUserList(SUser user);
}
