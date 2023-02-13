package com.example.springbeanlife.imports;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author jasper
 * @email jaspersteelxx@gmail.com
 * @create 2023-01-25 15:33
 **/
@Data
@Component
public class User implements InitializingBean {
    private String name;
    private Integer age;

    public void test() {
        System.out.println("testing user");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.name = "karl";
        this.age = 15;
    }
}
