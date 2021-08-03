package com.example.springboot_activiti.project.system.domain.po;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * s_log
 * @author 
 */
@Data
public class SLog implements Serializable {
    private Integer id;

    private String descr;

    private String opermodal;

    private String host;

    private String ipaddress;

    private String url;

    private String method;

    private String params;

    private String errormsg;

    private String operuser;

    private Date time;

    private String type;

    private String deptid;

    private Integer status;

    private String browser;

    private String sys;

    private static final long serialVersionUID = 1L;
}