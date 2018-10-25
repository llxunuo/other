package com.example.streamrebbitmqsender;

import com.example.streamrebbitmqsender.com.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding({Source.class})
@SpringBootApplication
public class StreamrebbitmqsenderApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(StreamrebbitmqsenderApplication.class, args);
    }

    @Autowired
    @Qualifier(Source.OUTPUT_ORDER)
    MessageChannel outputOrder;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("数据开始发送");
        outputOrder.send(MessageBuilder.withPayload("大家好").build());
    }
}
