package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author jasper
 * @email jaspersteelxx@gmail.com
 * @create 2023-01-21 18:41
 **/
@Data
@Builder
@ToString
@AllArgsConstructor
public class User {
    private String name;
    private String address;
    private int age;

    private void hello() {
        System.out.println("int user ");
    }

    private void cleanup() {
        System.out.println("destroy user");
    }
}
