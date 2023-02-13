package com.example.springbeanlife;

import com.example.springbeanlife.bean.Hello;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@Slf4j
public class SpringBeanLifeApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringBeanLifeApplication.class);
        Hello hello = context.getBean(Hello.class);
        System.out.println(hello);
    }
}
