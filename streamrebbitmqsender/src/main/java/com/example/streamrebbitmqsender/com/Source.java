package com.example.streamrebbitmqsender.com;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Source {
    String OUTPUT_ORDER = "outputOrder";

    @Output(OUTPUT_ORDER)
//    @Bean("outputOrder")
    MessageChannel outputOrder();
}
