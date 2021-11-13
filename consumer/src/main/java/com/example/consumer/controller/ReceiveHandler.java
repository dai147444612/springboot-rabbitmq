package com.example.consumer.controller;

import com.example.consumer.config.RabbitmqConfig;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReceiveHandler {

    //监听email队列
    @RabbitListener(queues = {RabbitmqConfig.QUEUE_INFORM_EMAIL})
    public void receive_email(Message message, Channel channel){
        System.out.println("QUEUE_INFORM_EMAIL msg"+message);
    }
    //监听sms队列
    @RabbitListener(queues = {RabbitmqConfig.QUEUE_INFORM_SMS})
    public void receive_sms(Message message, Channel channel){
        System.out.println("QUEUE_INFORM_SMS msg"+message.getBody());
    }

}
