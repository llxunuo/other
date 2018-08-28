package com.example.springbootbasis.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class ValueTest {

    @Value("${aa.bb}")
    public String s;

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String soutS(){
        System.out.println(s);
        return s;
    }
}
