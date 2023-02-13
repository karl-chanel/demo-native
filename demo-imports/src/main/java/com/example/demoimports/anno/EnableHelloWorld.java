package com.example.demoimports.anno;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author jasper
 * @email jaspersteelxx@gmail.com
 * @create 2023-01-29 14:48
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(HelloWorldImportSelector.class)
public @interface EnableHelloWorld {
}
