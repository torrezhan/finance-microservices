package ru.javabegin.finance.savingsgoalsvc.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "savings_goals")
@Data
public class SavingsGoal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId; // Replace User reference with userId

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double targetAmount;

    @Column(nullable = false)
    private Double currentAmount;

    @Column(nullable = false)
    private String currency;
}