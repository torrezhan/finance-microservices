package ru.javabegin.finance.commonconfig.security;

import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

@Configuration
public class JwtConfig {

    @Value("${app.jwt.secret}")
    private String jwtSecret;

    @Bean
    public SecretKey jwtSecretKey() {
        // Ensure the key is at least 512 bits (64 bytes) for HS512
        byte[] keyBytes = jwtSecret.getBytes(StandardCharsets.UTF_8);
        if (keyBytes.length < 64) {
            // If the key is too short, pad it with zeros
            byte[] paddedKey = new byte[64];
            System.arraycopy(keyBytes, 0, paddedKey, 0, keyBytes.length);
            return Keys.hmacShaKeyFor(paddedKey);
        } else {
            return Keys.hmacShaKeyFor(keyBytes);
        }
    }
} 