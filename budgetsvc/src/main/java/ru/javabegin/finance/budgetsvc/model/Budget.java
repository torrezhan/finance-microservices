package ru.javabegin.finance.budgetsvc.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "budgets")
@Data
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId; // Replace User reference with userId

    @Column(nullable = false)
    private Double monthlyLimit;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double amount;
}