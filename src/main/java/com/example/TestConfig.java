package com.example;

import com.example.entity.User;
import org.springframework.context.annotation.Bean;

/**
 * @author jasper
 * @email jaspersteelxx@gmail.com
 * @create 2023-01-31 04:06
 **/
public class TestConfig {
    @Bean("hola")
    public User testUser(){
        return new User("ss", "das", 15);
    }
    @Bean("ho")
    public User test1User(){
        return new User("ssxsda", "ddsacsdas", 20);
    }
}
