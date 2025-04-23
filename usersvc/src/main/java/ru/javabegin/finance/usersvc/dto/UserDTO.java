package ru.javabegin.finance.usersvc.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private Long id;
    private String email;
    private String password;
    private String name;
    private Double balance;
    private String currency;
    private List<Long> transactionIds;
    private List<Long> categoryIds;
    private List<Long> priorityIds;
    private List<Long> budgetIds;
    private List<Long> incomeIds;
    private List<Long> savingsGoalIds;
}
