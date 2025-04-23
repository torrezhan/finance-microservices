package ru.javabegin.finance.savingsgoalsvc.dto;

public class SavingsGoalDTO {
    private Long id;
    private String name;
    private Double targetAmount;
    private Double currentAmount;
    private String currency;
    private Long userId;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Double getTargetAmount() { return targetAmount; }
    public void setTargetAmount(Double targetAmount) { this.targetAmount = targetAmount; }
    public Double getCurrentAmount() { return currentAmount; }
    public void setCurrentAmount(Double currentAmount) { this.currentAmount = currentAmount; }
    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
}