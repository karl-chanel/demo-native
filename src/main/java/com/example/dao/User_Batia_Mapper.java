package com.example.dao;

import com.example.entity.User_Batis;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * @author jasper
 * @email jaspersteelxx@gmail.com
 * @create 2023-02-01 21:15
 **/

@Mapper
public interface User_Batia_Mapper {
    @ResultMap("userMap")
    @Select("select * from t_user where id = #{id} ")
    User_Batis getById(int id);

    @ResultMap("userMap")
    @Select("select * from t_user where username=#{username}  ")
    User_Batis getByUsername(String username);

    // 使用java bean传递多个参数，在xml中可以直接使用bean的property name，即#{username}
    @Insert(" insert into t_user (username, password) values (#{username}, #{password} )")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(User_Batis user);

    @Delete("delete from t_user where id = #{id} ")
    int delete(int id);

    // 两个参数，第二个参数是java bean，使用的时候需要使用#{user.username}
    @Update("update t_user set username =#{user.username},password=#{user.password} where id=#{id} ")
    int update(int id, User_Batis user);

    @Select("select * from t_user")
    @Results(id = "userMap",
            value = {
                    @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER),
                    @Result(column = "username", property = "username", jdbcType = JdbcType.VARCHAR),
                    @Result(column = "password", property = "password", jdbcType = JdbcType.VARCHAR),
            })
    List<User_Batis> getAllUsers();
}
