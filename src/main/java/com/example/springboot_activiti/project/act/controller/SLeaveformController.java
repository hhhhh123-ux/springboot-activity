package com.example.springboot_activiti.project.act.controller;

import com.example.springboot_activiti.common.constant.SystemConstant;
import com.example.springboot_activiti.framework.aspect.lang.SystemControllerLog;
import com.example.springboot_activiti.framework.web.domain.AjaxResult;
import com.example.springboot_activiti.project.act.doman.LeaveCompleteDTO;
import com.example.springboot_activiti.project.act.doman.LeaveCurrentDTO;
import com.example.springboot_activiti.project.act.doman.LeaveFormDTO;
import com.example.springboot_activiti.project.act.service.SLeaveformService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/*
*
* 请假    456
*
 */
@RestController
@RequestMapping("/sleaveform")
public class SLeaveformController {

    @Resource
    private SLeaveformService leaveformService;
    /**
     *
     */
    @SystemControllerLog(description = "增加申请", type = SystemConstant.add, operation = "申请模块")
    @PostMapping("/add")
    public AjaxResult add(@RequestBody LeaveFormDTO dto) {
        leaveformService.add(dto);
        return AjaxResult.success();
    }

    @SystemControllerLog(description = "申请列表", type = SystemConstant.list, operation = "申请模块")
    @PostMapping("/list")
    public AjaxResult list(@RequestBody LeaveCurrentDTO dto) {
        return AjaxResult.success(leaveformService.list(dto));
    }

    @SystemControllerLog(description = "申请提交", type = SystemConstant.Complete, operation = "申请模块")
    @PostMapping("/complete")
    public AjaxResult Complete(@RequestBody LeaveCompleteDTO dto) {
        leaveformService.Complete(dto);
        return AjaxResult.success();
    }

    @SystemControllerLog(description = "申请历史记录", type = SystemConstant.history, operation = "申请模块")
    @GetMapping("/history/{procinstid}")
    public AjaxResult history(@PathVariable(value = "procinstid", required = false) String procinstid) {

        return AjaxResult.success(leaveformService.history(procinstid));
    }

}
