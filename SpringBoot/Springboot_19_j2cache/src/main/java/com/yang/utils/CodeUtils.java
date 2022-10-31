package com.yang.utils;

import org.springframework.stereotype.Component;

/**
 * @Author yang
 * @Date 2022/8/3
 */
@Component
public class CodeUtils {
    private String[] patch = {"000000","00000","0000","000","00","0",""};
    public String generator(String tele){
        int hash = tele.hashCode();
        int encryption = 20206666;
        long result = hash ^ encryption;
        long nowTime = System.currentTimeMillis();
        result = result ^ nowTime;
        long code = result % 1000000;
        code = code < 0 ? -code : code;             //code 有可能是负数这里转为正数
        // code 有可能少于6位数，不足6位数补0
        String codeStr = code + "";
        int len = codeStr.length();
        return patch[len]+codeStr;
    }

}
