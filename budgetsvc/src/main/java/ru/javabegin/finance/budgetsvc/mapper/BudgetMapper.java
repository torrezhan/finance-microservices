package ru.javabegin.finance.budgetsvc.mapper;

import ru.javabegin.finance.budgetsvc.dto.BudgetDTO;
import ru.javabegin.finance.budgetsvc.model.Budget;

public class BudgetMapper {
    public static BudgetDTO toDTO(Budget budget) {
        if (budget == null) return null;

        BudgetDTO dto = new BudgetDTO();
        dto.setId(budget.getId());
        dto.setMonthlyLimit(budget.getMonthlyLimit());
        dto.setName(budget.getName());
        dto.setAmount(budget.getAmount());
        dto.setUserId(budget.getUserId());
        return dto;
    }

    public static Budget fromDTO(BudgetDTO dto) {
        if (dto == null) return null;

        Budget budget = new Budget();
        budget.setId(dto.getId());
        budget.setMonthlyLimit(dto.getMonthlyLimit());
        budget.setName(dto.getName());
        budget.setAmount(dto.getAmount());
        budget.setUserId(dto.getUserId());
        return budget;
    }
}