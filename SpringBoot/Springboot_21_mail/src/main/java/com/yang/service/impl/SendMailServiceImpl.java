package com.yang.service.impl;

import com.yang.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @Author yang
 * @Date 2022/8/4
 */
@Service
public class SendMailServiceImpl implements SendMailService {
    @Autowired
    private JavaMailSender javaMailSender;
    //发送人
    private String from = "1730475528@qq.com";
    //接收人
    private String to = "18370870760@139.com";
    //标题
    private String subject = "测试邮件";
    //正文
    private String context = "<img src='https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fup.enterdesk.com%2Fphoto%2F2012-3-2%2Fenterdesk.com-B526ECADD33DBD367676A93E051BA1EC.jpg&refer=http%3A%2F%2Fup.enterdesk.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1662206274&t=862335e188b708b26e6b247f6dcfea27' /><a href='https://www.baidu.com'>测试邮件正文内容。</a>";

    @Override
    public void sendMail() {
        try {
            MimeMessage mailMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mailMessage,true);
            helper.setFrom(from+"(小甜甜)");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(context,true);

            //添加附件
            File file = new File("D:\\yang\\Pictures\\下载\\3593429f9702a5b94d4dc2635a75b4e3.jpeg");
//            File file2 = new File("D:\\workSpace\\study\\SpringBoot\\Springboot_21_mail\\target\\Springboot_21_mail-0.0.1-SNAPSHOT.jar");
            helper.addAttachment(file.getName(),file);
//            helper.addAttachment(file2.getName(),file2);

            javaMailSender.send(mailMessage);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}
