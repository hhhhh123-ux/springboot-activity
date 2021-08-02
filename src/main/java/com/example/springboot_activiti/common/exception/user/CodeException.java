package com.example.springboot_activiti.common.exception.user;

public class CodeException extends UserException {

    private static final long serialVersionUID = 1L;

    public CodeException() {
         super("user.jcaptcha.expire",null);
    }
}
