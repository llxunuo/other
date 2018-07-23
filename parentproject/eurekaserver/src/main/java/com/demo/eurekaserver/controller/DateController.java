package com.demo.eurekaserver.controller;

import com.demo.common_utils.utils.CommonUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DateController {

    @RequestMapping("/date")
    public String getDate(){
        return CommonUtils.getDate().toString();
    }
}
