package com.example.controller;

import com.example.entity.BodyDemo;
import com.example.response.ResponseResult;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author jasper
 * @email jaspersteelxx@gmail.com
 * @create 2023-01-23 16:15
 **/
@Slf4j
@RequestMapping("/valid")
public class ValidController {
    @PostMapping(value = "/test", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseResult demo(@Valid @RequestBody BodyDemo demo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            errors.forEach(error -> {
                FieldError fieldError = (FieldError) error;
                log.error("Invalid Parameter : object - {},field - {},errorMessage - {}", fieldError.getObjectName(), fieldError.getField(), fieldError.getDefaultMessage());
            });
            return ResponseResult.fail("");
        }
        return ResponseResult.success(demo);
    }

}
