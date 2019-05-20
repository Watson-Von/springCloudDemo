package com.xiaofong.config;

import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public Request.Options feginOption() {
        return new Request.Options(80000, 80000);
    }

}
