package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * @author jasper
 * @email jaspersteelxx@gmail.com
 * @create 2023-01-22 18:11
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_user")
public class User_H2 {
    /**
     * 主键
     */
    @Id
    @Column(name = "user_id")
    private Integer userId;
    /**
     * 姓名
     */
    @Column(name = "user_name")
    private String userName;
    /**
     * 地址
     */
    @Column(name = "user_address")
    private String address;
    /**
     * 手机号
     */
    @Column(name = "user_phone")
    private String phone;
    /**
     * 日期
     */
    @Column(name = "user_date")
    private Date date;

}
