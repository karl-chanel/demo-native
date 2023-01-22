package com.example.reflectdemo;

import lombok.extern.slf4j.Slf4j;

/**
 * @author jasper
 * @email jaspersteelxx@gmail.com
 * @create 2023-01-16 20:19
 **/
@Slf4j
public class ReflectCaseDemo {
    public void hello(int counter) {
        counter += 1;
        log.info("reflect method called with {}", counter);
    }
}
