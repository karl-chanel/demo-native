package com.example.property;

import com.example.entity.User;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author jasper
 * @email jaspersteelxx@gmail.com
 * @create 2023-01-30 19:00
 **/
@Data
@Configuration
@PropertySource(value = "classpath:test.properties")
@ConfigurationProperties("test.config")
public class MyCustomProperties1 {
    //    @Value("${my.config.name:oop}")
    private String name;
    //    @Value("${my.config.age:50}")
       private Integer age;
       private Boolean enable;

    private Boolean e1nable;


    @Bean(name = "user-one")
    public User userBean() {
        return User.builder().address("memo").age(25).name("yoda").build();
    }
}

