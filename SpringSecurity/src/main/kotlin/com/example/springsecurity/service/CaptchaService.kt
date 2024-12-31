package com.example.springsecurity.service

import org.springframework.stereotype.Service
import java.util.concurrent.ConcurrentHashMap
import java.util.UUID

@Service
class CaptchaService {
    private val captchaStore = ConcurrentHashMap<String, CaptchaInfo>()

    fun generateCaptcha(): CaptchaResult {
        val key = UUID.randomUUID().toString()
        val code = generateRandomCode()
        captchaStore[key] = CaptchaInfo(code, System.currentTimeMillis())
        return CaptchaResult(key, code)
    }

    fun validateCaptcha(key: String, code: String): Boolean {
        val captchaInfo = captchaStore.remove(key) ?: return false
        if (System.currentTimeMillis() - captchaInfo.timestamp > 300000) { // 5分钟过期
            return false
        }
        return captchaInfo.code.equals(code, ignoreCase = true)
    }

    private fun generateRandomCode(): String {
        return (1..4)
            .map { ('0'..'9').random() }
            .joinToString("")
    }

    data class CaptchaInfo(val code: String, val timestamp: Long)
    data class CaptchaResult(val key: String, val code: String)
} 