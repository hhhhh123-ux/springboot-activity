package com.example.springboot_activiti.project.system.service.impl;

import com.example.springboot_activiti.common.constant.CaptchConstant;
import com.example.springboot_activiti.common.exception.user.CaptchException;
import com.example.springboot_activiti.common.exception.user.CodeException;
import com.example.springboot_activiti.framework.redis.RedisUtil;
import com.example.springboot_activiti.framework.security.LoginBody;
import com.example.springboot_activiti.framework.security.LoginUser;
import com.example.springboot_activiti.framework.security.service.TokenService;
import com.example.springboot_activiti.project.system.service.SysLoginService;
import lombok.SneakyThrows;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysLoginserviceImpl implements SysLoginService {
    @Resource
    private TokenService tokenService;
    @Resource
    private AuthenticationManager authenticationManager;
    @Resource
    private RedisUtil redisUtil;

    @Override
    public String login(LoginBody loginBody)  {
        String username = loginBody.getUsername();
        String password = loginBody.getPassword();
        String uuid=loginBody.getUuid();
        String verify = CaptchConstant.CAPTCHA_CODE_KEY + uuid;
        String code=loginBody.getCode();
        String captch= (String) redisUtil.get(verify);
        redisUtil.del(verify);
        if(captch==null){
            throw new CodeException();
        }
        if(!code.equals(captch)){
          throw new CaptchException();
        }
        // 用户验证
        Authentication authentication = null;
        try {
            // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
            authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (Exception e) {
            if (e instanceof BadCredentialsException) {
                throw new RuntimeException();
            } else {
                throw new RuntimeException(e.getMessage());
            }
        }
        LoginUser loginUser=(LoginUser) authentication.getPrincipal();
        return tokenService.CreateToken(loginUser);
    }
}
