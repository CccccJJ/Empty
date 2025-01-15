package com.example.springsecurity.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configurers.DefaultLoginPageConfigurer
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {

        http.csrf { it.disable() }
            .exceptionHandling { it.disable() }
            .headers { it.disable() }
            .sessionManagement { it.disable() }
            .securityContext { it.disable() }
            .requestCache { it.disable() }
            .anonymous { it.disable() }
            .servletApi { it.disable() }
            .logout { it.disable() }
            .cors { it.disable() }

        http
            .authorizeHttpRequests { it.anyRequest().authenticated() }
            .formLogin {  }
            .exceptionHandling {  }
            .securityContext {  }



        return http.build()
    }

}
