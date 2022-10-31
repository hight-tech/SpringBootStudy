package com.yang;

import com.yang.service.SendMailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot21MailApplicationTests {

    @Autowired
    private SendMailService sendMailService;
    @Test
    void contextLoads() {
        sendMailService.sendMail();
    }

}
