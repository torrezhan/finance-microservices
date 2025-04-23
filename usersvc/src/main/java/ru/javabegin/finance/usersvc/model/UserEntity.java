package ru.javabegin.finance.usersvc.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double balance;

    @Column(nullable = false)
    private String currency = "KZT";

    @ElementCollection
    @CollectionTable(name = "user_transactions", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "transaction_id")
    private List<Long> transactionIds;

    @ElementCollection
    @CollectionTable(name = "user_categories", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "category_id")
    private List<Long> categoryIds;

    @ElementCollection
    @CollectionTable(name = "user_priorities", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "priority_id")
    private List<Long> priorityIds;

    @ElementCollection
    @CollectionTable(name = "user_budgets", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "budget_id")
    private List<Long> budgetIds;

    @ElementCollection
    @CollectionTable(name = "user_incomes", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "income_id")
    private List<Long> incomeIds;

    @ElementCollection
    @CollectionTable(name = "user_savings_goals", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "savings_goal_id")
    private List<Long> savingsGoalIds;

    public UserEntity(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
