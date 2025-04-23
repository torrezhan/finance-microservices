package ru.javabegin.finance.usersvc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import ru.javabegin.finance.usersvc.dto.AuthRequest;
import ru.javabegin.finance.usersvc.security.JwtUtil;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;

    @PostMapping("/login")
    public String authenticate(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authRequest.getEmail(), authRequest.getPassword()
                    )
            );
        } catch (Exception e) {
            throw new Exception("Invalid email or password");
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getEmail());
        return jwtUtil.generateToken(userDetails.getUsername());
    }
}
