package com.example.springboot_activiti.framework.web.controller;

import com.example.springboot_activiti.common.constant.SystemConstant;
import com.example.springboot_activiti.common.utils.file.FileUtils;
import com.example.springboot_activiti.framework.aspect.lang.SystemControllerLog;
import com.example.springboot_activiti.framework.config.RuConfig;
import com.example.springboot_activiti.framework.web.domain.AjaxResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;


@RestController
public class FileController {

    @Resource
    private RuConfig ruConfig;

    @SystemControllerLog(description = "上传功能", type = SystemConstant.add, operation = "上传下载模块")
    @PostMapping("/upload")
    public AjaxResult upload(@RequestParam("file") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            return AjaxResult.error("请选择要上传的文件");
        } else {
            String path = ruConfig.getProfile();
            FileUtils.uploadFile(file.getBytes(), path, file.getOriginalFilename());
            return AjaxResult.success(path);
        }
    }




}
