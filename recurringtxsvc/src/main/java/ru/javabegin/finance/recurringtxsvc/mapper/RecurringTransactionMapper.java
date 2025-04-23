package ru.javabegin.finance.recurringtxsvc.mapper;

import ru.javabegin.finance.recurringtxsvc.dto.RecurringTransactionDTO;
import ru.javabegin.finance.recurringtxsvc.model.RecurringTransaction;

public class RecurringTransactionMapper {
    public static RecurringTransactionDTO toDTO(RecurringTransaction recurringTransaction) {
        if (recurringTransaction == null) return null;

        RecurringTransactionDTO dto = new RecurringTransactionDTO();
        dto.setId(recurringTransaction.getId());
        dto.setName(recurringTransaction.getName());
        dto.setAmount(recurringTransaction.getAmount());
        dto.setFrequency(recurringTransaction.getFrequency());
        dto.setStartDate(recurringTransaction.getStartDate());
        dto.setEndDate(recurringTransaction.getEndDate());
        dto.setUserId(recurringTransaction.getUserId());
        return dto;
    }

    public static RecurringTransaction fromDTO(RecurringTransactionDTO dto) {
        if (dto == null) return null;

        RecurringTransaction recurringTransaction = new RecurringTransaction();
        recurringTransaction.setId(dto.getId());
        recurringTransaction.setName(dto.getName());
        recurringTransaction.setAmount(dto.getAmount());
        recurringTransaction.setFrequency(dto.getFrequency());
        recurringTransaction.setStartDate(dto.getStartDate());
        recurringTransaction.setEndDate(dto.getEndDate());
        recurringTransaction.setUserId(dto.getUserId());
        return recurringTransaction;
    }
}