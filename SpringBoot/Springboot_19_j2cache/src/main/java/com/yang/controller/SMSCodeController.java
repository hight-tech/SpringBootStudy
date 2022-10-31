package com.yang.controller;

import com.yang.domain.SMSCode;
import com.yang.service.SMSCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author yang
 * @Date 2022/8/3
 */
@RestController
@RequestMapping("/sms")
public class SMSCodeController {

    @Autowired
    private SMSCodeService smsCodeService;

    @GetMapping("{tele}")
    public String getCode(@PathVariable String tele){
        return smsCodeService.sendCodeToSMS(tele);
    }

    @PostMapping
    public Boolean checkCode(@RequestBody SMSCode smsCode){
        return smsCodeService.checkCode(smsCode);
    }

}
