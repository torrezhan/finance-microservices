package ru.javabegin.finance.usersvc.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "users")
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    private String name;

    private Double balance;

    private String currency;

    @ElementCollection
    private List<Long> transactionIds;

    @ElementCollection
    private List<Long> categoryIds;

    @ElementCollection
    private List<Long> priorityIds;

    @ElementCollection
    private List<Long> budgetIds;

    @ElementCollection
    private List<Long> incomeIds;

    @ElementCollection
    private List<Long> savingsGoalIds;
}
