package com.yang.service.impl;

import com.yang.domain.SMSCode;
import com.yang.service.SMSCodeService;
import com.yang.utils.CodeUtils;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeoutException;

/**
 * @Author yang
 * @Date 2022/8/3
 */
@Service
public class SMSCodeServiceImpl implements SMSCodeService {
    @Autowired
    private CodeUtils codeUtils;
    @Autowired
    private MemcachedClient memcachedClient;

//    @Override
////    @Cacheable(value = "smsCode",key = "#tele")       //这个有把数据从缓存中取出和放的功能
//    @CachePut(value = "smsCode",key = "#tele")          //这个只有把数据放到缓存中的功能
//    public String sendCodeToSMS(String tele) {
//        String code = codeUtils.generator(tele);
//        return code;
//    }
//
//    @Override
//    public Boolean checkCode(SMSCode smsCode) {
//        //取出内存中的验证码与传递过来的验证码比对，如果相同，返回true
//        String code = smsCode.getCode();
//        String cacheCode = codeUtils.get(smsCode.getTele());
//        return code.equals(cacheCode);
//    }

    //以下是使用springboot中使用xmemcached
    @Override
    public String sendCodeToSMS(String tele) {
        String code = codeUtils.generator(tele);
        try {
            memcachedClient.set(tele,10,code);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (MemcachedException e) {
            throw new RuntimeException(e);
        }
        return code;
    }

    @Override
    public Boolean checkCode(SMSCode smsCode) {
        String code = null;
        try {
            if (memcachedClient.get(smsCode.getTele()) == null) {
                return false;
            }
            code = memcachedClient.get(smsCode.getTele()).toString();
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (MemcachedException e) {
            throw new RuntimeException(e);
        }
        return smsCode.getCode().equals(code);
    }

}
