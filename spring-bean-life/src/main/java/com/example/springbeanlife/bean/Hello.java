package com.example.springbeanlife.bean;

import com.example.springbeanlife.imports.User;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author jasper
 * @email jaspersteelxx@gmail.com
 * @create 2023-01-25 14:16
 **/
@Slf4j
@ToString
@Component("hello-world")
public class Hello{
    private String name;
    private Integer age;
    private User user;

    public Hello(User user) {
        this.user = user;
    }

    public void test() {
        log.info("test");
    }
}
