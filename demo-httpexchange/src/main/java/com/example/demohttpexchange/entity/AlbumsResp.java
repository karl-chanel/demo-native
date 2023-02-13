package com.example.demohttpexchange.entity;

import lombok.Setter;
import lombok.ToString;

/**
 * @author jasper
 * @email jaspersteelxx@gmail.com
 * @create 2023-02-03 20:51
 **/
@Setter
@ToString
public class AlbumsResp {

    private Long id;
    private Long userId;
    private String title;

}