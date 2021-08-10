package com.example.springboot_activiti.project.act.doman;

import lombok.Data;

@Data
public class LeaveHistoryDTO {

    private String historyId;
    private String procinstid;
    private String activityId;
    private String activityName;
    private String title;
    private String leaveType;
    private String deptId;
    private String taskId;
    private String area;

}
