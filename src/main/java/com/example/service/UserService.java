package com.example.service;

import com.example.entity.User_H2;

import java.util.List;

/**
 * @author jasper
 * @email jaspersteelxx@gmail.com
 * @create 2023-01-22 01:03
 **/
public interface UserService {


    void addUser(User_H2 user);

    /**
     * @return user list
     */
    List<User_H2> list();

    User_H2 findById(Integer integer);

    User_H2 findByName(String name);

}
