package com.example.springboot_activiti;

import org.activiti.engine.*;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricIdentityLink;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Event;
import org.activiti.engine.task.Task;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.util.List;

@SpringBootTest
public class ActivitiDemo {

    @Test
    public void Test() {
        //
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //
        RepositoryService repositoryService = processEngine.getRepositoryService();

        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("process/Leave.bpmn")
                .addClasspathResource("process/Leave.png")
                .name("请假流程")
                .deploy();
        System.out.println("id=" + deployment.getId());
        System.out.println("name:" + deployment.getName());
    }

    //开启流程
    @Test
    public void StartProcessTest() {
        //
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //
        RuntimeService runtimeService = processEngine.getRuntimeService();

        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("mymLeave");
        System.out.println("流程定义id=" + processInstance.getProcessDefinitionId());
        System.out.println("流程实例id=" + processInstance.getId());
        System.out.println("流程Name=" + processInstance.getName());
        System.out.println("流程Name=" + processInstance.getProcessDefinitionName());
        System.out.println("当前活动Id=" + processInstance.getActivityId());
    }

    //查询当前人的任务
    @Test
    public void QueryStartProcessTest() {
        //任务负责人
        String assignee = "mangerr";
        //
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //创建taskService
        TaskService taskService = processEngine.getTaskService();
        //查询list通过key和任务负责人
        List<Task> list = taskService.createTaskQuery().processDefinitionKey("mymLeave").taskAssignee(assignee).list();

        for (Task task : list) {
            System.out.println("任务id：" + task.getId());
            System.out.println("任务name：" + task.getName());
            System.out.println("任务负责人：" + task.getAssignee());
            System.out.println("流程id：" + task.getProcessInstanceId());

        }
    }

    //处理任务
    @Test
    public void Complete() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        TaskService taskService = processEngine.getTaskService();

//        List<Task> list= taskService.createTaskQuery().processDefinitionKey("mymLeave").taskAssignee(assignee).list();

        taskService.complete("2504");

    }

    //查询流程定义

    @Test
    public void QueryProcess() {
        //1.得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.创建RepositoryService对象
        RepositoryService repositoryService = processEngine.getRepositoryService();
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
        //4.设置条件，并查询出当前的所有流程定义   查询条件：流程定义的key=mymLeave
        //orderByProcessDefinitionVersion() 设置排序方式,根据流程定义的版本号进行排序
        List<ProcessDefinition> list = processDefinitionQuery.processDefinitionKey("mymLeave")
                .orderByProcessDefinitionVersion()
                .desc().list();
        //5.输出流程定义信息
        for (ProcessDefinition processDefinition : list) {
            System.out.println("流程定义ID：" + processDefinition.getId());
            System.out.println("流程定义名称：" + processDefinition.getName());
            System.out.println("流程定义的Key：" + processDefinition.getKey());
            System.out.println("流程定义的版本号：" + processDefinition.getVersion());
            System.out.println("流程部署的ID:" + processDefinition.getDeploymentId());
        }
    }

    //删除流程
    @Test
    public void deleteDeployment() {

        String deploymentId = "1";
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        repositoryService.deleteDeployment(deploymentId);
    }


    //查询图片
    @Test
    public void ProcessDefinitionResource() throws IOException {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();

        //根据流程定义id查询部署id
        String processDefinitionId = "mymLeave:1:4";
        ProcessDefinition processDefinition = repositoryService
                .createProcessDefinitionQuery()
                .processDefinitionId(processDefinitionId).singleResult();
        //部署id
        String deploymentId = processDefinition.getDeploymentId();

        //bpmn文件
        //bpmn资源文件名称
        String resourceName_bpmn = processDefinition.getResourceName();
        //bpmn资源文件输入流
        InputStream inputStream_bpmn = repositoryService.getResourceAsStream(deploymentId, resourceName_bpmn);

        //png文件
        //png文件名称
        String resourceName_png = processDefinition.getDiagramResourceName();
        //png资源文件输入流
        InputStream inputStream_png = repositoryService.getResourceAsStream(deploymentId, resourceName_png);

        //构造输入流
        File file_bpmn = new File("d:/image/" + resourceName_bpmn);
        File file_png = new File("d:/image/" + resourceName_png);

        FileOutputStream fileOutputStream_bpmn = new FileOutputStream(file_bpmn);
        FileOutputStream fileOutputStream_png = new FileOutputStream(file_png);

        //流复制
        byte[] b = new byte[1024];
        int len = -1;
        while ((len = inputStream_bpmn.read(b, 0, 1024)) != -1) {
            fileOutputStream_bpmn.write(b, 0, len);
        }

        while ((len = inputStream_png.read(b, 0, 1024)) != -1) {
            fileOutputStream_png.write(b, 0, len);
        }

        //关闭流
        inputStream_bpmn.close();
        inputStream_png.close();
        fileOutputStream_bpmn.close();
        fileOutputStream_png.close();


    }

    //查询历史记录
    @Test
    public void ProcessHistory() throws IOException {

        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        HistoryService historyService = processEngine.getHistoryService();
        //List<HistoricIdentityLink> linkList=historyService.getHistoricIdentityLinksForTask("");
        // List<HistoricIdentityLink> linkList=historyService.getHistoricIdentityLinksForProcessInstance("2501");

        List<HistoricActivityInstance> list = processEngine.getHistoryService()
               .createHistoricActivityInstanceQuery().processInstanceId("2501")
                .list();
        for (HistoricActivityInstance hpi : list) {
            System.out.println("流程定义ID：" + hpi.getProcessDefinitionId());
            System.out.println("流程实例ID：" + hpi.getProcessInstanceId());
            System.out.println("ID：" + hpi.getId());
            System.out.println("活动id："+hpi.getActivityId());
            System.out.println("活动名称："+hpi.getActivityName());
            System.out.println("=======================================");
        }
//        for(HistoricIdentityLink history:linkList){
//            System.out.println(":"+history.getProcessInstanceId());
//            System.out.println(":"+history.getTaskId());
//            System.out.println(":"+history.getUserId());
//            System.out.println(":"+history.getGroupId());
//            System.out.println();
//        }

    }

}
