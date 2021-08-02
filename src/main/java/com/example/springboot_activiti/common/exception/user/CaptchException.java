package com.example.springboot_activiti.common.exception.user;



public class CaptchException extends UserException {
    private static final long serialVersionUID = 1L;

    public CaptchException() {
        super("user.jcaptcha.error",null);
    }
}
