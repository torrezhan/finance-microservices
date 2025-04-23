package ru.javabegin.finance.usersvc.mapper;

import ru.javabegin.finance.usersvc.model.UserEntity;
import ru.javabegin.finance.usersvc.dto.UserDTO;

public class UserMapper {
    public static UserDTO toDTO(UserEntity userEntity) {
        if (userEntity == null) return null;
        UserDTO dto = new UserDTO();
        dto.setId(userEntity.getId());
        dto.setEmail(userEntity.getEmail());
        dto.setName(userEntity.getName());
        userEntity.setPassword(userEntity.getPassword());
        dto.setBalance(userEntity.getBalance());
        dto.setCurrency(userEntity.getCurrency());
        dto.setTransactionIds(userEntity.getTransactionIds());
        dto.setCategoryIds(userEntity.getCategoryIds());
        dto.setPriorityIds(userEntity.getPriorityIds());
        dto.setBudgetIds(userEntity.getBudgetIds());
        dto.setIncomeIds(userEntity.getIncomeIds());
        dto.setSavingsGoalIds(userEntity.getSavingsGoalIds());
        return dto;
    }

    public static UserEntity fromDTO(UserDTO dto) {
        if (dto == null) return null;
        UserEntity userEntity = new UserEntity();
        userEntity.setId(dto.getId());
        userEntity.setEmail(dto.getEmail());
        userEntity.setName(dto.getName());
        userEntity.setPassword(userEntity.getPassword());
        userEntity.setBalance(dto.getBalance());
        userEntity.setCurrency(dto.getCurrency());
        userEntity.setTransactionIds(dto.getTransactionIds());
        userEntity.setCategoryIds(dto.getCategoryIds());
        userEntity.setPriorityIds(dto.getPriorityIds());
        userEntity.setBudgetIds(dto.getBudgetIds());
        userEntity.setIncomeIds(dto.getIncomeIds());
        userEntity.setSavingsGoalIds(dto.getSavingsGoalIds());
        return userEntity;
    }
}