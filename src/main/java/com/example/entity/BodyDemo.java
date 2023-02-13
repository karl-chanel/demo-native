package com.example.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

/**
 * @author jasper
 * @email jaspersteelxx@gmail.com
 * @create 2023-01-23 16:21
 **/
@Data
@AllArgsConstructor
@Builder
public class BodyDemo {
    @NotNull(message = "name can't be null")
    private String name;
    @NotNull(message = "age can't be null")
    @Range(min = 10, max = 100)
    private Integer age;
    @NotNull(message = "address can't be null")
    private String address;
    @Email
    private String email;
}
