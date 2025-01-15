package com.example.springsecurity.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/hello")
class HelloApi {

    @GetMapping("/")
    fun hello(): String {
        return "hello";
    }

}