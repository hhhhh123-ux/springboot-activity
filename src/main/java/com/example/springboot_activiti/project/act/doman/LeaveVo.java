package com.example.springboot_activiti.project.act.doman;

import lombok.Data;

@Data
public class LeaveVo {

    private String id;
    private String procinstid;
    private String proposerName;
    private String proposerId;
    private String title;
    private String leaveType;
    private String deptId;
    private String taskId;
    private String area;
}
