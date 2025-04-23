package ru.javabegin.finance.usersvc.mapper;

import ru.javabegin.finance.usersvc.dto.UserDTO;
import ru.javabegin.finance.usersvc.model.UserEntity;

public class UserMapper {

    public static UserDTO toDTO(UserEntity entity) {
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setEmail(entity.getEmail());
        dto.setPassword(entity.getPassword());
        dto.setName(entity.getName());
        dto.setBalance(entity.getBalance());
        dto.setCurrency(entity.getCurrency());
        dto.setTransactionIds(entity.getTransactionIds());
        dto.setCategoryIds(entity.getCategoryIds());
        dto.setPriorityIds(entity.getPriorityIds());
        dto.setBudgetIds(entity.getBudgetIds());
        dto.setIncomeIds(entity.getIncomeIds());
        dto.setSavingsGoalIds(entity.getSavingsGoalIds());
        return dto;
    }

    public static UserEntity fromDTO(UserDTO dto) {
        UserEntity entity = new UserEntity();
        entity.setId(dto.getId());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setName(dto.getName());
        entity.setBalance(dto.getBalance());
        entity.setCurrency(dto.getCurrency());
        entity.setTransactionIds(dto.getTransactionIds());
        entity.setCategoryIds(dto.getCategoryIds());
        entity.setPriorityIds(dto.getPriorityIds());
        entity.setBudgetIds(dto.getBudgetIds());
        entity.setIncomeIds(dto.getIncomeIds());
        entity.setSavingsGoalIds(dto.getSavingsGoalIds());
        return entity;
    }
}
