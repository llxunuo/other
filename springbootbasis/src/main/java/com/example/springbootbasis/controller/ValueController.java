package com.example.springbootbasis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValueController {

    @Value("${aa.bb}")
    public String s;

    @Autowired
    public ValueTest vt;

    @GetMapping("sout")
    public String soutS(){
//        ValueTest vt = new ValueTest();
        System.out.println(s);
        return s+"--"+vt.soutS()+"--"+vt.getS();
    }
}
