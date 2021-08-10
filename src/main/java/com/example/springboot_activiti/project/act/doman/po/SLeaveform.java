package com.example.springboot_activiti.project.act.doman.po;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * s_leaveform
 * @author 
 */
@Data
public class SLeaveform implements Serializable {
    private Integer id;

    /**
     * 实例id
     */
    private String procinstid;

    /** 发起人Id */
    private String proposerId;

    private String agentId;

    private String title;

    private Integer leavetype;

    private String leavecontent;

    /**
     * 生效时间
     */
    private Date leavetime;

    /**
     * 请假到期时间
     */
    private Date expiretime;

    private Date createtime;

    private Date endtime;

    private String reply;

    private Integer status;

    private Date currdate;

    private Integer deptId;

    private Integer area;

    private static final long serialVersionUID = 1L;
}