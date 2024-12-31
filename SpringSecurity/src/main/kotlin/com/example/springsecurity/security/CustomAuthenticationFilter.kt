package com.example.springsecurity.security

import com.example.springsecurity.dto.LoginRequest
import com.example.springsecurity.dto.ApiResponse
import com.example.springsecurity.service.CaptchaService
import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.stereotype.Component

@Component
class CustomAuthenticationFilter(
    private val authenticationManager: AuthenticationManager,
    private val jwtTokenProvider: JwtTokenProvider,
    private val captchaService: CaptchaService,
    private val objectMapper: ObjectMapper
) : UsernamePasswordAuthenticationFilter() {

    init {
        setFilterProcessesUrl("/api/auth/login")
    }

    override fun attemptAuthentication(request: HttpServletRequest, response: HttpServletResponse): Authentication {
        val loginRequest = objectMapper.readValue(request.inputStream, LoginRequest::class.java)
        
        // 验证验证码
        if (!captchaService.validateCaptcha(loginRequest.captchaKey, loginRequest.captcha)) {
            throw InvalidCaptchaException("验证码错误")
        }

        val authenticationToken = UsernamePasswordAuthenticationToken(
            loginRequest.username,
            loginRequest.password
        )

        return authenticationManager.authenticate(authenticationToken)
    }

    override fun successfulAuthentication(
        request: HttpServletRequest,
        response: HttpServletResponse,
        chain: FilterChain,
        authResult: Authentication
    ) {
        val token = jwtTokenProvider.generateToken(authResult)
        val loginResponse = LoginResponse(token, authResult.name)
        
        response.contentType = "application/json"
        response.characterEncoding = "UTF-8"
        objectMapper.writeValue(response.writer, ApiResponse(
            success = true,
            data = loginResponse
        ))
    }

    override fun unsuccessfulAuthentication(
        request: HttpServletRequest,
        response: HttpServletResponse,
        failed: AuthenticationException
    ) {
        response.contentType = "application/json"
        response.characterEncoding = "UTF-8"
        response.status = HttpServletResponse.SC_UNAUTHORIZED
        
        objectMapper.writeValue(response.writer, ApiResponse<Unit>(
            success = false,
            message = "用户名或密码错误"
        ))
    }
} 