package org.example;

import org.example.bean.Hello;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
@Configuration
@ComponentScan
public class App {
    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class);
//        Hello hello = context.getBean(Hello.class);
//        hello.hello();
        ClassPathXmlApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("hello.xml");
        Hello bean = xmlApplicationContext.getBean(Hello.class);
        bean.hello();
    }
}
