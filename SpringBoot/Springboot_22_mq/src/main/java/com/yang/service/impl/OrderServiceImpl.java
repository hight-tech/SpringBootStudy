package com.yang.service.impl;

import com.yang.service.MessageService;
import com.yang.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author yang
 * @Date 2022/8/7
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private MessageService messageService;
    @Override
    public void order(String id) {
        //一系列操作，包括各种服务调用，处理各种业务
        System.out.println("订单的处理开始");
        //短信信息处理
        messageService.sendMessage(id);

        System.out.println("订单的处理结束");
        System.out.println();
    }
}
