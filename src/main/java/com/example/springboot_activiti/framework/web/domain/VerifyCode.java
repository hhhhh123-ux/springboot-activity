package com.example.springboot_activiti.framework.web.domain;

import lombok.Data;

@Data
public class VerifyCode {

    private String code;

    private byte[] imgBytes;

    private long expireTime;
}
