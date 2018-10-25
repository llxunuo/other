package com.example.streamsender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootApplication
@EnableBinding({Source.class})
public class RabbitSender {

    public static void main(String[] args) {
        SpringApplication.run(RabbitSender.class, "--server.port=9001","--spring.cloud.stream.bindings.outputOrder.destination=mqTestDefault");
        RabbitSender rabbitSender = new RabbitSender();
        rabbitSender.sendM();
    }

    @Autowired
    @Output(Source.OUTPUT_ORDER)
    MessageChannel outputOrder;


//    @InboundChannelAdapter(value = Source.OUTPUT_ORDER)
    public Message<String> sendM() {
        System.out.println("数据开始发送");
        outputOrder.send(MessageBuilder.withPayload("大家好").build());
        return MessageBuilder.withPayload("大家好").build();
    }
}
