package com.yang.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author yang
 * @Date 2022/8/8
 */
@Component
@Endpoint(id = "pay",enableByDefault = true)
public class PayEndPoint {

    @ReadOperation
    public Object getPay(){
        Map payMap = new HashMap();
        payMap.put("level 1","6");
        payMap.put("level 2","600");
        payMap.put("level 3","60000");
//        System.out.println("=================");
//        System.out.println("=======pay=======");
//        System.out.println("=================");
        return payMap;
    }
}
