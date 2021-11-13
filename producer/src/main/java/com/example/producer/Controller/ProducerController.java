package com.example.producer.Controller;

import com.example.producer.Entity.SendMsg;
import com.example.producer.config.RabbitMqConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.nio.ByteBuffer;

@RestController
public class ProducerController {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @PostMapping("setMsg")
    public void setMsg(@RequestBody SendMsg sendMsg){
        /**
         * 参数：
         * 1、交换机名称
         * 2、routingKey
         * 3、消息内容
         */
        rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE_TOPICS_INFORM, "inform.sms",sendMsg.getMsg());

    }
}
