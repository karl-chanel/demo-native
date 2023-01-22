package com.example.dao;

import com.example.entity.User_H2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author jasper
 * @email jaspersteelxx@gmail.com
 * @create 2023-01-22 01:01
 **/
@Repository
public interface UserDao extends JpaRepository<User_H2, Integer> {
    User_H2 findByUserName(String username);
}
