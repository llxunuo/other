package com.example.springbootbasis.component;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class PrintMessage {

    public void printString(String string){
        System.out.println("打印信息："+string);
    }

}
