package com.example.streamrabbitmqreceiver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

import javax.print.attribute.standard.DateTimeAtCompleted;
import java.util.Date;

@SpringBootApplication
@EnableBinding(Sink.class)
public class StreamrabbitmqreceiverApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamrabbitmqreceiverApplication.class, args);

    }

    @StreamListener(Sink.INPUT)
    public void inputMessage(Message<String> message){
        System.out.println("收到的消息是:"+message.getPayload());
        System.out.println("收到的消息是:"+message.getHeaders());
        System.out.println("收到的消息是:"+message.getClass());

    }
}
