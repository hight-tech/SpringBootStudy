package com.yang.service;

import com.yang.domain.SMSCode;

public interface SMSCodeService {
    String sendCodeToSMS(String tele);
    Boolean checkCode(SMSCode smsCode);
}
