package com.example.elkdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class IndexController {

    private Logger log = LoggerFactory.getLogger(IndexController.class);

    /**
     *@Description:测试日志输出
     *@return:java.lang.Object
     */
    @RequestMapping("/log")
    public String log() {
        String optDate = "2018-06-17";
        String optTime = "01:57:52";
        String optUri = "/assettype-api/assettype/productTypeTree";
        String opturiType = "0";
        String userId = "31";
        String userCode = "lisi";
        String userName = "张三测试";
        String sysId = "0";
        String orgId = "1";
        String remark = "备注";
        log.debug(optDate + "|" + optTime + "|" + optUri + "|" + opturiType + "|" + userId + "|" + userCode + "|" + userName + "|" + sysId + "|" + orgId + "|" + remark + "|");
        log.info(optDate + "|" + optTime + "|" + optUri + "|" + opturiType + "|" + userId + "|" + userCode + "|" + userName + "|" + sysId + "|" + orgId + "|");
        log.warn(optDate + "|" + optTime + "|" + optUri + "|" + opturiType + "|" + userId + "|" + userCode + "|" + userName + "|" + sysId + "|" + orgId + "|" + remark + "|");
        log.error(optDate + "|" + optTime + "|" + optUri + "|" + opturiType + "|" + userId + "|" + userCode + "|" + userName + "|" + sysId + "|" + orgId + "|");
        return "success";
    }
}

