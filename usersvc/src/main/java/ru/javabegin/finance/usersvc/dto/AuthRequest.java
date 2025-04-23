package ru.javabegin.finance.usersvc.dto;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;
}
