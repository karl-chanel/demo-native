package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.entity.User_H2;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author jasper
 * @email jaspersteelxx@gmail.com
 * @create 2023-01-22 00:58
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    /**
     * @param user user
     */
    @Override
    public void addUser(User_H2 user) {
        userDao.save(user);
    }

    /**
     * @return user list
     */
    @Override
    public List<User_H2> list() {
        return userDao.findAll();
    }

    @Override
    public User_H2 findById(Integer integer) {
        Optional<User_H2> byId = userDao.findById(integer);
        return byId.orElse(null);
    }

    @Override
    public User_H2 findByName(String name) {
        User_H2 user_h2 = userDao.findByUserName(name);
        return user_h2;
    }
}
