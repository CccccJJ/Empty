package com.example.springsecurity

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity

@EnableWebSecurity
@SpringBootApplication(exclude = arrayOf(DataSourceAutoConfiguration::class))
class SpringSecurityApplication

fun main(args: Array<String>) {
    runApplication<SpringSecurityApplication>(*args)
}
