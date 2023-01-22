package com.example.controller;

import com.example.entity.User_H2;
import com.example.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author jasper
 * @email jaspersteelxx@gmail.com
 * @create 2023-01-22 00:57
 **/
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("add")
    public User_H2 add(User_H2 user) {
        userService.addUser(user);
        return user;
    }

    /**
     * http://localhost:8080/user/list .
     *
     * @return user list
     */
    @GetMapping("list")
    public List<User_H2> list() {
        return userService.list();
    }

    @GetMapping("find/{id}")
    public User_H2 find(@PathVariable("id") Integer id) {
        return userService.findById(id);

    }

    @GetMapping("find")
    public User_H2 find(@RequestParam(required = true, name = "name") String name) {
        return userService.findByName(name);

    }
}
