package com.example;

import jakarta.annotation.PostConstruct;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * @author jasper
 * @email jaspersteelxx@gmail.com
 * @create 2023-01-31 05:16
 **/
@Component
@ToString
public class TestBean {
    private String name;
    @PostConstruct
    public void init() {
        this.name = "hello";
    }

}
