package com.leyou.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogConfig {
    @Bean
    public Logger.Level sdfd(){
        return Logger.Level.FULL;
    }





}
