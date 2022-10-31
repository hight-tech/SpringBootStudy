package com.yang.service.impl;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.yang.domain.SMSCode;
import com.yang.service.SMSCodeService;
import com.yang.utils.CodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


/**
 * @Author yang
 * @Date 2022/8/3
 */
@Service
public class SMSCodeServiceImpl implements SMSCodeService {
    @Autowired
    private CodeUtils codeUtils;

    //remote
//    @CreateCache(area = "sms",name = "jetCache",expire = 10,timeUnit = TimeUnit.SECONDS)
    @CreateCache(name = "jetCache",expire = 10,timeUnit = TimeUnit.SECONDS,cacheType = CacheType.LOCAL)
    private Cache<String,String> jetCache;

    @Override
    public String sendCodeToSMS(String tele) {
        String code = codeUtils.generator(tele);
        jetCache.put(tele,code);
        return code;
    }

    @Override
    public Boolean checkCode(SMSCode smsCode) {
        String code = jetCache.get(smsCode.getTele());
        return smsCode.getCode().equals(code);
    }

}
