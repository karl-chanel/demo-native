package com.example;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author jasper
 * @email jaspersteelxx@gmail.com
 * @create 2023-01-31 04:45
 **/
public class MyApplicationInitializer implements ApplicationContextInitializer{
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {

//        applicationContext.addApplicationListener(event -> {
//            System.out.println("trigger an event: "+event.getClass().getName()+" with time "+event.getTimestamp());
//        });
//        applicationContext.getEnvironment().getSystemProperties().forEach((key, value) -> {
//            System.out.println(key + ":" + value);
//        });
    }


}
