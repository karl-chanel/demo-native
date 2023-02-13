package com.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jasper
 * @email jaspersteelxx@gmail.com
 * @create 2023-02-01 21:14
 **/
@Data
@NoArgsConstructor
public class User_Batis {
    private Integer id;
    private String username;
    private String password;
    public User_Batis(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
