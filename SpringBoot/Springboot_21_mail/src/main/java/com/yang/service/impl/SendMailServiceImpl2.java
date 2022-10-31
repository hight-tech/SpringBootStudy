package com.yang.service.impl;

import com.yang.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @Author yang
 * @Date 2022/8/4
 */
//@Service
public class SendMailServiceImpl2 implements SendMailService {
    @Autowired
    private JavaMailSender javaMailSender;
    //发送人
    private String from = "1730475528@qq.com";
    //接收人
    private String to = "18370870760@139.com";
    //标题
    private String subject = "测试邮件";
    //正文
    private String context = "测试邮件正文内容。";

    @Override
    public void sendMail() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from+"(小甜甜)");
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(context);


        javaMailSender.send(mailMessage);
    }
}
