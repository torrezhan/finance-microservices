package ru.javabegin.finance.incomesvc.mapper;

import ru.javabegin.finance.incomesvc.dto.IncomeDTO;
import ru.javabegin.finance.incomesvc.model.Income;

public class IncomeMapper {
    public static IncomeDTO toDTO(Income income) {
        if (income == null) return null;

        IncomeDTO dto = new IncomeDTO();
        dto.setId(income.getId());
        dto.setSource(income.getSource());
        dto.setAmount(income.getAmount());
        dto.setDate(income.getDate());
        dto.setDescription(income.getDescription());
        dto.setUserId(income.getUserId());
        return dto;
    }

    public static Income fromDTO(IncomeDTO dto) {
        if (dto == null) return null;

        Income income = new Income();
        income.setId(dto.getId());
        income.setSource(dto.getSource());
        income.setAmount(dto.getAmount());
        income.setDate(dto.getDate());
        income.setDescription(dto.getDescription());
        income.setUserId(dto.getUserId());
        return income;
    }
}