package com.airline.userinfoservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@Configuration
public class FeignConfig {
    
    @Bean
    public MappingJackson2HttpMessageConverter feignConverter() {
        return new MappingJackson2HttpMessageConverter();
    }
} 