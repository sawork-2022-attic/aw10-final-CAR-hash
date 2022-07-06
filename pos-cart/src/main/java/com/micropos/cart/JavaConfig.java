package com.micropos.cart;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;

@Configuration
public class JavaConfig {
    @Bean
    public DirectChannel sampleChannel() {
        return new DirectChannel();
    }

}
