package ru.javabegin.finance.savingsgoalsvc.mapper;

import ru.javabegin.finance.savingsgoalsvc.dto.SavingsGoalDTO;
import ru.javabegin.finance.savingsgoalsvc.model.SavingsGoal;

public class SavingsGoalMapper {
    public static SavingsGoalDTO toDTO(SavingsGoal savingsGoal) {
        if (savingsGoal == null) return null;

        SavingsGoalDTO dto = new SavingsGoalDTO();
        dto.setId(savingsGoal.getId());
        dto.setName(savingsGoal.getName());
        dto.setTargetAmount(savingsGoal.getTargetAmount());
        dto.setCurrentAmount(savingsGoal.getCurrentAmount());
        dto.setCurrency(savingsGoal.getCurrency());
        dto.setUserId(savingsGoal.getUserId());
        return dto;
    }

    public static SavingsGoal fromDTO(SavingsGoalDTO dto) {
        if (dto == null) return null;

        SavingsGoal savingsGoal = new SavingsGoal();
        savingsGoal.setId(dto.getId());
        savingsGoal.setName(dto.getName());
        savingsGoal.setTargetAmount(dto.getTargetAmount());
        savingsGoal.setCurrentAmount(dto.getCurrentAmount());
        savingsGoal.setCurrency(dto.getCurrency());
        savingsGoal.setUserId(dto.getUserId());
        return savingsGoal;
    }
}