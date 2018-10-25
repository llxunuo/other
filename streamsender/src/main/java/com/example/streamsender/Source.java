package com.example.streamsender;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.MessageChannel;

public interface Source {
    String OUTPUT_ORDER = "outputOrder";

    @Output(OUTPUT_ORDER)
//    @Bean("outputOrder")
    MessageChannel outputOrder();
}
