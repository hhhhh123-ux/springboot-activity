package com.example.springboot_activiti.framework.web.domain;

import com.example.springboot_activiti.common.constant.AjaxConstant;
import lombok.Data;

import java.util.HashMap;

@Data
public class AjaxResult extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;
    public static final String CODE = "code";
    public static final String MSG = "msg";
    public static final String DATA = "data";

    //对初始话
    public AjaxResult() {

    }

    public static AjaxResult success() {
        return AjaxResult.success("成功");
    }

    public static AjaxResult error() {
        return AjaxResult.error("失败");
    }

    public static AjaxResult error(String code,String msg) {
        return AjaxResult.error(code,msg);
    }

    public static AjaxResult success(String msg) {
        AjaxResult json = new AjaxResult();
        json.put(MSG,msg);
        json.put(CODE,"200");
        return json;
    }

    public static AjaxResult error(String msg) {
        AjaxResult json = new AjaxResult();
        json.put(MSG,msg);
        json.put(CODE,"500");
        return json;
    }

    public static AjaxResult success(String code, String msg,Object data) {
        AjaxResult json = new AjaxResult();
        json.put(CODE, code);
        json.put(MSG, msg);
        json.put(DATA,data);
        return json;
    }

    public static AjaxResult success(Object data) {
        return AjaxResult.success(AjaxConstant.code_success,AjaxConstant.msg_success,data);
    }

}
