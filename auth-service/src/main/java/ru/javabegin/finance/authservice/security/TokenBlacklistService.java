package ru.javabegin.finance.authservice.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class TokenBlacklistService {

    private final RedisTemplate<String, String> redisTemplate;
    private final JwtTokenProvider jwtTokenProvider;

    public TokenBlacklistService(RedisTemplate<String, String> redisTemplate, JwtTokenProvider jwtTokenProvider) {
        this.redisTemplate = redisTemplate;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public void blacklistToken(String token) {
        String username = jwtTokenProvider.getUsernameFromToken(token);
        String key = "blacklist:" + username + ":" + token;
        
        // Store the token in Redis with expiration time
        redisTemplate.opsForValue().set(key, "blacklisted");
        redisTemplate.expire(key, jwtTokenProvider.getTokenExpirationInSeconds(), TimeUnit.SECONDS);
        
        log.info("Token blacklisted for user: {}", username);
    }

    public boolean isTokenBlacklisted(String token) {
        String username = jwtTokenProvider.getUsernameFromToken(token);
        String key = "blacklist:" + username + ":" + token;
        
        return Boolean.TRUE.equals(redisTemplate.hasKey(key));
    }
} 