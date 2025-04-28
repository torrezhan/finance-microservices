package ru.javabegin.finance.authservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.javabegin.finance.authservice.dto.AuthRequest;
import ru.javabegin.finance.authservice.dto.AuthResponse;
import ru.javabegin.finance.authservice.dto.UserDTO;
import ru.javabegin.finance.authservice.exception.ResourceNotFoundException;
import ru.javabegin.finance.authservice.security.JwtTokenProvider;
import ru.javabegin.finance.authservice.repository.UserRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    public AuthResponse authenticate(AuthRequest request) {
        try {
            log.info("Attempting to authenticate user: {}", request.getUsername());
            
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );
            
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtTokenProvider.generateToken(authentication);
            
            UserDTO user = userRepository.findByUsername(request.getUsername())
                    .map(userEntity -> new UserDTO(
                            userEntity.getId(),
                            userEntity.getUsername(),
                            userEntity.getEmail(),
                            userEntity.getPassword(),
                            userEntity.getFirstName(),
                            userEntity.getLastName(),
                            userEntity.getRoles(),
                            userEntity.isEnabled()
                    ))
                    .orElseThrow(() -> new ResourceNotFoundException("User not found: " + request.getUsername()));
            
            log.info("Successfully authenticated user: {}", request.getUsername());
            
            return new AuthResponse(
                token,
                user.getUsername(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName()
            );
        } catch (BadCredentialsException e) {
            log.error("Invalid credentials for user: {}", request.getUsername());
            throw new BadCredentialsException("Invalid username or password");
        } catch (AuthenticationException e) {
            log.error("Authentication failed for user: {}", request.getUsername(), e);
            throw e;
        } catch (ResourceNotFoundException e) {
            log.error("User not found: {}", request.getUsername());
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error during authentication for user: {}", request.getUsername(), e);
            throw new RuntimeException("Authentication failed", e);
        }
    }
} 