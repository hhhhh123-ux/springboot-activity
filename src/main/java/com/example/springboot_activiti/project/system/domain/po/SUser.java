package com.example.springboot_activiti.project.system.domain.po;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import com.example.springboot_activiti.framework.web.domain.po.BasePO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * s_user
 *
 * @author
 */
@Data
public class SUser extends BasePO {
    private Integer userId;

    private Integer deptId;

    private String userName;

    private String nickName;

    private String userType;

    private String email;

    private String phone;

    private String sex;

    @JsonIgnore
    private String password;

    private String status;

    private SDept dept;
//    private String createby;
//
//    private String updateby;
//
//    private Date createtime;
//
//    private Date updatetime;


}