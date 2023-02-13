package com.example.demokotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
@RequestMapping("main")
open class DemoKotlinApplication {
    @GetMapping("echo")
    fun hello(name: String): String {
        return "hello $name !!!"
    }
}
@RestController
@RequestMapping("hello")
class HelloController {
    @GetMapping("echo")
    fun hello(name: String): String {
        return "hello $name !!!"
    }
}
fun main(args: Array<String>) {
    runApplication<DemoKotlinApplication>(*args)
}
