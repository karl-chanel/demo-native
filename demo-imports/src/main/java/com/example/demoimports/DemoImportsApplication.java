package com.example.demoimports;

import com.example.demoimports.anno.EnableHelloWorld;
import com.example.demoimports.config.User;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableHelloWorld
public class DemoImportsApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(DemoImportsApplication.class).web(WebApplicationType.NONE).run(args);
        User user = context.getBean(User.class);
        System.out.println(user);
    }

}
