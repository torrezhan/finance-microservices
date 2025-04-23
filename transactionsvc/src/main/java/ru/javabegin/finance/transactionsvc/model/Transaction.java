package ru.javabegin.finance.transactionsvc.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "transactions")
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    @Column(nullable = false)
    private String currency;

    @Column
    private String description;

    @ElementCollection
    @CollectionTable(name = "transaction_categories", joinColumns = @JoinColumn(name = "transaction_id"))
    @Column(name = "category_id")
    private Set<Long> categoryIds;
}

