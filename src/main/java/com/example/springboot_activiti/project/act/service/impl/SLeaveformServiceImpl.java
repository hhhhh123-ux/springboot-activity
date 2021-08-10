package com.example.springboot_activiti.project.act.service.impl;

import com.example.springboot_activiti.common.constant.LeaveFormConstant;
import com.example.springboot_activiti.common.utils.ServletUtils;
import com.example.springboot_activiti.framework.security.LoginUser;
import com.example.springboot_activiti.framework.security.service.TokenService;
import com.example.springboot_activiti.project.act.doman.*;
import com.example.springboot_activiti.project.act.doman.po.SLeaveform;
import com.example.springboot_activiti.project.act.mapper.SLeaveformMapper;
import com.example.springboot_activiti.project.act.service.SLeaveformService;
import com.example.springboot_activiti.project.system.domain.po.SDept;
import com.example.springboot_activiti.project.system.domain.po.SUser;
import org.activiti.engine.*;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class SLeaveformServiceImpl implements SLeaveformService {
    //申请工作流的进程ID
    private final static String ProcessInstanceByKey = "apply";

    private final static String assigne = "jd";

    private final static String area = "area";

    private final static String shi = "shi";
    @Resource
    private SLeaveformMapper leaveformMapper;

    @Resource
    private RuntimeService runtimeService;

    @Autowired
    IdentityService identityService;

    @Autowired
    TaskService taskService;
    @Autowired
    HistoryService historyService;
    @Resource
    private TokenService tokenService;

    @Transactional
    @Override
    public void add(LeaveFormDTO dto) {
        if (LeaveFormConstant.type_0.equals(dto.getType())) {
            SLeaveform leaveform = dto.getLeaveform();
            leaveformMapper.insertSelective(leaveform);
        } else if (LeaveFormConstant.type_1.equals(dto.getType())) {
            String formId = "";
            String businessKey = "";
            SLeaveform leaveform = dto.getLeaveform();
            LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
            leaveform.setProposerId(loginUser.getUser().getUserId().toString());
            leaveformMapper.insertSelective(leaveform);
            //用户Id
            String proposerId = leaveform.getProposerId();
            identityService.setAuthenticatedUserId(proposerId);
            formId = leaveform.getId().toString();
            businessKey = LeaveFormConstant.Apply_code + formId;
            ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(ProcessInstanceByKey, businessKey);
            System.out.println("流程定义id=" + processInstance.getProcessDefinitionId());
            System.out.println("流程实例id=" + processInstance.getId());
            System.out.println("流程Name=" + processInstance.getName());
            System.out.println("流程Name=" + processInstance.getProcessDefinitionName());
            System.out.println("当前活动Id=" + processInstance.getActivityId());
            leaveform.setProcinstid(processInstance.getId());
            leaveformMapper.updateByPrimaryKeySelective(leaveform);
        }
    }

    @Override
    public List<LeaveVo> list(LeaveCurrentDTO dto) {
        List<LeaveVo> leaveVos = new ArrayList<>();
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        SUser user = loginUser.getUser();
        SDept dept = user.getDept();
        List<Task> tasks = taskService.createTaskQuery().processDefinitionKey(ProcessInstanceByKey).taskAssignee(dept.getShen())
                .list();
        System.out.println(tasks);
        tasks.forEach(item -> {
            System.out.println("processInstanceId:" + item.getProcessInstanceId());
            if(dept.getShen().equals(assigne)){
                LeaveVo leaveVo = leaveformMapper.selectByTask(item.getProcessInstanceId(),dept.getDeptId().toString(),null);
                if(leaveVo!=null){
                    leaveVo.setTaskId(item.getId());
                    leaveVos.add(leaveVo);
                }
            } else if(dept.getShen().equals(area)){
                LeaveVo leaveVo = leaveformMapper.selectByTask(item.getProcessInstanceId(),null,dept.getDeptId().toString());
                if(leaveVo!=null){
                    leaveVo.setTaskId(item.getId());
                    leaveVos.add(leaveVo);
                }
            }else if(dept.getShen().equals(shi)){
                LeaveVo leaveVo = leaveformMapper.selectByTask(item.getProcessInstanceId(),null,null);
                if(leaveVo!=null){
                    leaveVo.setTaskId(item.getId());
                    leaveVos.add(leaveVo);
                }
            }

        });
        return leaveVos;
    }

    @Override
    public void Complete(LeaveCompleteDTO dto) {
        taskService.complete(dto.getTaskId());
    }

    @Override
    public List<LeaveHistoryDTO> history(String procinstid) {
        List<LeaveHistoryDTO> leaveHistoryDTOS=new ArrayList<>();
        List<HistoricActivityInstance> list=historyService.createHistoricActivityInstanceQuery().processInstanceId(procinstid).list();
        System.out.println(list);
        for (HistoricActivityInstance hpi : list) {
            LeaveHistoryDTO leaveHistoryDTO=new LeaveHistoryDTO();
            System.out.println("流程定义ID：" + hpi.getProcessDefinitionId());
            System.out.println("流程实例ID：" + hpi.getProcessInstanceId());
            System.out.println("ID：" + hpi.getId());
            System.out.println("活动id："+hpi.getActivityId());
            System.out.println("活动名称："+hpi.getActivityName());
            System.out.println("=======================================");
            LeaveVo leaveVo = leaveformMapper.selectByTask(hpi.getProcessInstanceId(),null,null);
            leaveHistoryDTO.setArea(leaveVo.getArea());
            leaveHistoryDTO.setLeaveType(leaveVo.getLeaveType());
            leaveHistoryDTO.setTitle(leaveVo.getTitle());
            leaveHistoryDTO.setTaskId(leaveVo.getTaskId());
            leaveHistoryDTO.setDeptId(leaveVo.getDeptId());
            leaveHistoryDTO.setHistoryId(hpi.getId());
            leaveHistoryDTO.setProcinstid(hpi.getProcessInstanceId());
            leaveHistoryDTO.setActivityId(hpi.getActivityId());
            leaveHistoryDTO.setActivityName(hpi.getActivityName());
            leaveHistoryDTOS.add(leaveHistoryDTO);
        }
        return leaveHistoryDTOS;
    }
}
