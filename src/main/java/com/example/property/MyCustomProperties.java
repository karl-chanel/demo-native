package com.example.property;

import com.example.entity.User;
import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author jasper
 * @email jaspersteelxx@gmail.com
 * @create 2023-01-21 22:52
 **/
@Data
@Configuration
@PropertySource(value = "classpath:test.yml", factory = YmlConfigFactory.class)
@ConfigurationProperties("test.config")
public class MyCustomProperties {
    //    @Value("${my.config.name:oop}")
    private String name;
    //    @Value("${my.config.age:50}")
    private Integer age;

    @ConditionalOnExpression("${test.config.enable:false}")
    @Bean(name = "user", initMethod = "hello", destroyMethod = "cleanup")
    public User userBean() {
        return User.builder().address("BeiJing").age(15).name("oop").build();
    }
}
