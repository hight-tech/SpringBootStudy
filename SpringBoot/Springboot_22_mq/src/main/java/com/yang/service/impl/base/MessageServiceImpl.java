package com.yang.service.impl.base;

import com.yang.service.MessageService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @Author yang
 * @Date 2022/8/7
 */
//@Service
public class MessageServiceImpl implements MessageService {

    private ArrayList<String> list= new ArrayList<String>();
    @Override
    public void sendMessage(String id) {
        System.out.println("待发送短信的订单已纳入处理队列，id："+id);
        list.add(id);
    }

    @Override
    public String doMessage() {
        String id = list.remove(0);
        System.out.println("已完成短信发送业务，id："+id);
        return id;
    }
}
