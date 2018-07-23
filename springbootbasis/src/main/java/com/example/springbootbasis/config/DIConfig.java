package com.example.springbootbasis.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.example.springbootbasis.component.CallPrintMessage;
import com.example.springbootbasis.component.PrintMessage;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;

@Configuration
public class DIConfig {

    @Bean
    public CallPrintMessage callPrintMessage(){
        return new CallPrintMessage(printMessage());
    }

    @Bean
    public PrintMessage printMessage(){
        return new PrintMessage();
    }
}
