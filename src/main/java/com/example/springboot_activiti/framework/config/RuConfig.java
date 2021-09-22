package com.example.springboot_activiti.framework.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "activiti")
@Data
public class RuConfig {
     private String name;
     private String version;
     private String profile;

     public static String profile(){
         return profile();
     }

}
