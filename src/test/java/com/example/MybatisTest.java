package com.example;

import com.example.dao.User_Batia_Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author jasper
 * @email jaspersteelxx@gmail.com
 * @create 2023-02-01 21:28
 **/
@SpringBootTest
public class MybatisTest {
    @Autowired
    User_Batia_Mapper mapper;

    @Test
//    @RepeatedTest(5)
    public void test() {
//        User_Batis userBatis = new User_Batis();
//        userBatis.setUsername("yoga");
//        userBatis.setPassword("2119994705");
//        int i = mapper.insert(userBatis);
//        System.out.println(i);
        mapper.getAllUsers().forEach(System.out::println);
    }
}
