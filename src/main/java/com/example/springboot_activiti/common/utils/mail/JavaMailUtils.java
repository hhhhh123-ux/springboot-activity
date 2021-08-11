package com.example.springboot_activiti.common.utils.mail;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * 邮件工具类
 *
 * @author gaozhiqiang
 * @date 2021/8/11
 */
@Service
@Slf4j
public class JavaMailUtils {



    @Autowired
    JavaMailSender javaMailSender;
    /**
     * 发送普通文本邮件
     * @param from 发件人，如果未指定则使用默认配置的 service28@bulkea.oristand.com
     * @param to 收件人
     * @param subject 邮件主题
     * @param text 邮件内容
     */
    public void send(String subject, String text, String from, String to) {
        SimpleMailMessage message = new SimpleMailMessage();
        try {
            message.setSubject(subject);
            message.setText(text);
            message.setFrom(from);
            message.setTo(to);
            javaMailSender.send(message);
            log.info("发送邮件成功：" + from + to + subject + text);
        }catch (Exception e){
             e.printStackTrace();
        }

    }

    /**
     * 发送普通文本邮件
     * @param from 发件人，如果未指定则使用默认配置的 service28@bulkea.oristand.com
     * @param to 收件人
     * @param jpg 图片
     * @param url
     * @param subject 邮件主题
     * @param text 邮件内容
     */
    public void sendMail(String subject, String text, String from, String to, String jpg, String url) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helpers = new MimeMessageHelper(mimeMessage, true);
        try {
            helpers.setSubject(subject);
            helpers.setText("<p style='color:green'>" + text + "</p>", true);
            helpers.addAttachment(jpg, new File(url));//附件在本地位置
            helpers.setTo(from);//发送给他人邮箱
            helpers.setFrom(to);//发送者，本人邮箱
            javaMailSender.send(mimeMessage);
            log.error("发送带图片邮件成功：发件人：{},收件人：{},抄送：{},主题：{}"+from+to+text+subject);
        }catch (MessagingException e){
            e.printStackTrace();

        }
    }

}
