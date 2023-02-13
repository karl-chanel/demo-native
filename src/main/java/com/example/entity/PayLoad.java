package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author jasper
 * @email jaspersteelxx@gmail.com
 * @create 2023-01-21 18:41
 **/
@Data
@Builder
@AllArgsConstructor
public class PayLoad {
    private String location;
    private Integer age;
    private String who;
    private User user;
}
