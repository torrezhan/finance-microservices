package ru.javabegin.finance.transactiontagsvc.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "transaction_tags")
@Data
public class TransactionTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId; // Replace User reference with userId

    @Column(nullable = false)
    private String name;

    @Column
    private String description;
}