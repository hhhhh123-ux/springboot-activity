package com.example.springboot_activiti.project.system.mapper;

import com.example.springboot_activiti.project.system.domain.po.SUser;

import java.util.List;

public interface SUserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(SUser record);

    int insertSelective(SUser record);

    SUser selectByPrimaryKey(Integer userId);

    SUser selectByUserName(String username);

    int updateByPrimaryKeySelective(SUser record);

    int updateByPrimaryKey(SUser record);

    public List<SUser> selectUserList(SUser user);
}