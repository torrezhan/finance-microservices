package ru.javabegin.finance.authservice.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Slf4j
@Component
public class JwtTokenProvider {

    @Value("${app.jwt.secret}")
    private String jwtSecret;

    @Value("${app.jwt.expiration}")
    private int jwtExpirationInMs;

    @Value("${app.jwt.refresh-expiration}")
    private int refreshExpirationInMs;

    private SecretKey key;

    @PostConstruct
    public void init() {
        // Ensure the key is at least 512 bits (64 bytes) for HS512
        byte[] keyBytes = jwtSecret.getBytes(StandardCharsets.UTF_8);
        if (keyBytes.length < 64) {
            // If the key is too short, pad it with zeros
            byte[] paddedKey = new byte[64];
            System.arraycopy(keyBytes, 0, paddedKey, 0, keyBytes.length);
            this.key = Keys.hmacShaKeyFor(paddedKey);
        } else {
            this.key = Keys.hmacShaKeyFor(keyBytes);
        }
    }

    public String generateToken(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(key)
                .compact();
    }

    public String generateRefreshToken(Authentication authentication) {
        try {
            String username = authentication.getName();
            Date now = new Date();
            Date expiryDate = new Date(now.getTime() + refreshExpirationInMs);

            return Jwts.builder()
                    .setSubject(username)
                    .claim("type", "refresh")
                    .setIssuedAt(now)
                    .setExpiration(expiryDate)
                    .signWith(key)
                    .compact();
        } catch (Exception e) {
            log.error("Error generating refresh token", e);
            throw new RuntimeException("Failed to generate refresh token", e);
        }
    }

    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return claims.getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token);
            return true;
        } catch (SecurityException ex) {
            log.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty");
        }
        return false;
    }

    public boolean isRefreshToken(String token) {
        try {
            Claims claims = Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
            
            return "refresh".equals(claims.get("type", String.class));
        } catch (JwtException | IllegalArgumentException e) {
            log.error("Error checking token type", e);
            return false;
        }
    }

    public int getTokenExpirationInSeconds() {
        return jwtExpirationInMs / 1000;
    }
} 