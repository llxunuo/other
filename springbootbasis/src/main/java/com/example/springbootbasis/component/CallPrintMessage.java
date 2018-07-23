package com.example.springbootbasis.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableConfigurationProperties(User.class)
public class CallPrintMessage {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private PrintMessage printMessage;
    public CallPrintMessage(PrintMessage printMessage) {
        this.printMessage = printMessage;
    }

    @RequestMapping("/print")
    public String print(){
        printMessage.printString("haha");
        return "haha";
    }

    @Autowired
    private User user;

    @RequestMapping("/user")
    public User retUser(){
//        logger.info("123123");
//        user.setUserName("张三");
        System.out.println(user.getId()+"-"+user.getName());
        return user;
    }
}
