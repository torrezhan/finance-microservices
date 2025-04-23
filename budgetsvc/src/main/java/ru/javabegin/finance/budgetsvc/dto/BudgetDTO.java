package ru.javabegin.finance.budgetsvc.dto;

public class BudgetDTO {
    private Long id;
    private String name;
    private Double monthlyLimit;
    private Double amount;
    private Long userId;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Double getMonthlyLimit() { return monthlyLimit; }
    public void setMonthlyLimit(Double monthlyLimit) { this.monthlyLimit = monthlyLimit; }
    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
}