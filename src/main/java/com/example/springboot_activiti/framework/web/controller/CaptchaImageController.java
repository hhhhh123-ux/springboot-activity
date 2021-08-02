package com.example.springboot_activiti.framework.web.controller;


import com.example.springboot_activiti.common.constant.CaptchConstant;
import com.example.springboot_activiti.common.utils.Base64;
import com.example.springboot_activiti.common.utils.RandomUtil;
import com.example.springboot_activiti.framework.redis.RedisUtil;
import com.example.springboot_activiti.framework.web.domain.AjaxResult;
import com.example.springboot_activiti.framework.web.domain.VerifyCode;
import com.example.springboot_activiti.framework.web.service.IVerifyCodeGen;
import com.example.springboot_activiti.framework.web.service.IVerifyCodeGenImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;


@RestController
@Slf4j
public class CaptchaImageController {
    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/captchaImage")
    public AjaxResult captchaImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        IVerifyCodeGen iVerifyCodeGen = new IVerifyCodeGenImpl();
        BufferedImage image = null;
        String uuid = RandomUtil.randomNumberString(3);
        String verify = CaptchConstant.CAPTCHA_CODE_KEY + uuid;
        System.out.println(verify);
        //设置长宽
        VerifyCode verifyCode = iVerifyCodeGen.generate(80, 28);
        String code = verifyCode.getCode();
        byte[] imgBytes = verifyCode.getImgBytes();
        Boolean b = redisUtil.set(verify, code, CaptchConstant.CAPTCHA_EXPIRATION);

        System.out.println("验证码:"+code);

        ByteArrayInputStream in = new ByteArrayInputStream(imgBytes);
        image = ImageIO.read(in);
        FastByteArrayOutputStream os = new FastByteArrayOutputStream();
        try {
            ImageIO.write(image, "jpg", os);
        } catch (IOException e) {
            return AjaxResult.error(e.getMessage());
        }
        AjaxResult ajax = AjaxResult.success();
        ajax.put("uuid", uuid);
        ajax.put("img", Base64.encode(os.toByteArray()));
        return ajax;
    }
}
