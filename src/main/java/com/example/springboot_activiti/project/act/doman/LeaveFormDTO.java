package com.example.springboot_activiti.project.act.doman;

import com.example.springboot_activiti.project.act.doman.po.SLeaveform;
import lombok.Data;

@Data
public class LeaveFormDTO {
    private String type;
    private SLeaveform leaveform;
}
