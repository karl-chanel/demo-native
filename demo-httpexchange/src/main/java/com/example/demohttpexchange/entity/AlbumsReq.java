package com.example.demohttpexchange.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Getter;

/**
 * @author jasper
 * @email jaspersteelxx@gmail.com
 * @create 2023-02-03 20:51
 **/
@Builder
@Getter
public class AlbumsReq {
    @NotNull
    @Positive
    private Long userId;
    @NotBlank
    private String title;
}