package com.example.springboot_activiti.project.code.controller;

import com.example.springboot_activiti.common.constant.SystemConstant;
import com.example.springboot_activiti.framework.aspect.lang.SystemControllerLog;
import com.example.springboot_activiti.framework.web.domain.AjaxResult;
import com.example.springboot_activiti.project.code.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/code")
public class CodeController {

    @Autowired
    private CodeService codeService;


    @GetMapping("/query/{id}")
    public AjaxResult query(@PathVariable("id") String id) {
        return AjaxResult.success(codeService.query(id));
    }


}
