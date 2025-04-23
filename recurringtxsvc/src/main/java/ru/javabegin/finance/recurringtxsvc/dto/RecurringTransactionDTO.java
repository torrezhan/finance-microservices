package ru.javabegin.finance.recurringtxsvc.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class RecurringTransactionDTO {
    private Long id;
    private String name;
    private BigDecimal amount;
    private String frequency; // e.g., DAILY, WEEKLY, MONTHLY
    private LocalDate startDate;
    private LocalDate endDate;
    private Long userId;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public String getFrequency() { return frequency; }
    public void setFrequency(String frequency) { this.frequency = frequency; }
    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
}