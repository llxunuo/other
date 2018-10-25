package com.example.streamsender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

@SpringBootApplication
@EnableBinding(Sink.class)
public class RabbitReceiver {

    public static void main(String[] args) {
        SpringApplication.run(RabbitReceiver.class, "--server.port=9002","--spring.cloud.stream.bindings.input.destination=mqTestDefault");
    }

    @StreamListener(Sink.INPUT)
    public void inputMessage(Message<String> message){
        System.out.println("收到的消息是:"+message.getPayload());
    }
}
