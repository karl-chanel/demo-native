package com.example.demoimports.config;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author jasper
 * @email jaspersteelxx@gmail.com
 * @create 2023-01-29 14:53
 **/
@Data
@AllArgsConstructor
public class User {
    private String name;
    private String desprition;
    private String address;
    private Integer age;

}
