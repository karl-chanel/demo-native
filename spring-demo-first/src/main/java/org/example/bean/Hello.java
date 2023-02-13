package org.example.bean;

import org.springframework.stereotype.Component;

/**
 * @author jasper
 * @email jaspersteelxx@gmail.com
 * @create 2023-02-01 02:10
 **/
@Component("hello")
public class Hello {
    public void hello(){
        System.out.println("inside hello!!");
    }
}
