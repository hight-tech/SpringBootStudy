package com.yang.service.impl.activemq.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @Author yang
 * @Date 2022/8/8
 */
@Component
public class MessageListener {

    @JmsListener(destination = "order.queue.id")        //监听order.queue.id的消息，然后处理
    @SendTo("order.other.queue.id")                     //监听order.queue.id的消息，然后发送给order.other.queue.id
    public String receive(String id){
        System.out.println("正在完成短信发送业务，id："+id);
        return "new:"+id;
    }
}
