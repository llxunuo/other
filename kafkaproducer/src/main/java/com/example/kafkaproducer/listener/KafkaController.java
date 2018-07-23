package com.example.kafkaproducer.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @RequestMapping("/kafka")
    public String testKafka(){
        int iMax = 6;
        for (int i = 1; i < iMax; i++) {
            send("key" + i, "data" + i);
        }
        return "success";
    }


    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void send(String key, String value){
        kafkaTemplate.send("test12",key,value);
    }
}
