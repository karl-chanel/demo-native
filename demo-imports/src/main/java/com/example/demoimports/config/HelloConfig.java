package com.example.demoimports.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jasper
 * @email jaspersteelxx@gmail.com
 * @create 2023-01-29 14:53
 **/
@Configuration
public class HelloConfig {
    @Bean
    public  User hello(){
        return new User("karl","no desp","anhui",20);
    }
}
