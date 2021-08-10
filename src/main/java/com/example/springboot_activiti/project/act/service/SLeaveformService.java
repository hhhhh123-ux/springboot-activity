package com.example.springboot_activiti.project.act.service;

import com.example.springboot_activiti.project.act.doman.*;


import java.util.List;

public interface SLeaveformService {

    public void add(LeaveFormDTO dto);

    public List<LeaveVo> list(LeaveCurrentDTO dto);

    public void Complete(LeaveCompleteDTO dto);

    public List<LeaveHistoryDTO> history(String procinstid);
}
