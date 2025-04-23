package ru.javabegin.finance.usersvc.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class UserDTO {
    private Long id;
    @NotNull(message = "Email cannot be null")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    private String password;

    @NotNull(message = "Name cannot be null")
    private String name;

    @NotNull(message = "Balance cannot be null")
    private Double balance;

    @NotNull(message = "Currency cannot be null")
    private String currency;
    private List<Long> transactionIds;
    private List<Long> categoryIds;
    private List<Long> priorityIds;
    private List<Long> budgetIds;
    private List<Long> incomeIds;
    private List<Long> savingsGoalIds;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Double getBalance() { return balance; }
    public void setBalance(Double balance) { this.balance = balance; }
    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }
    public List<Long> getTransactionIds() { return transactionIds; }
    public void setTransactionIds(List<Long> transactionIds) { this.transactionIds = transactionIds; }
    public List<Long> getCategoryIds() { return categoryIds; }
    public void setCategoryIds(List<Long> categoryIds) { this.categoryIds = categoryIds; }
    public List<Long> getPriorityIds() { return priorityIds; }
    public void setPriorityIds(List<Long> priorityIds) { this.priorityIds = priorityIds; }
    public List<Long> getBudgetIds() { return budgetIds; }
    public void setBudgetIds(List<Long> budgetIds) { this.budgetIds = budgetIds; }
    public List<Long> getIncomeIds() { return incomeIds; }
    public void setIncomeIds(List<Long> incomeIds) { this.incomeIds = incomeIds; }
    public List<Long> getSavingsGoalIds() { return savingsGoalIds; }
    public void setSavingsGoalIds(List<Long> savingsGoalIds) { this.savingsGoalIds = savingsGoalIds; }
    public String getPassword() { return password; }  // Getter for password
    public void setPassword(String password) { this.password = password; }  // Setter for password
}
