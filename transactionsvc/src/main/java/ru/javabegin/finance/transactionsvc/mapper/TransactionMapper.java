package ru.javabegin.finance.transactionsvc.mapper;

import ru.javabegin.finance.transactionsvc.dto.TransactionDTO;
import ru.javabegin.finance.transactionsvc.model.Transaction;
import ru.javabegin.finance.transactionsvc.model.TransactionStatus;

public class TransactionMapper {
    public static TransactionDTO toDTO(Transaction transaction) {
        if (transaction == null) return null;

        TransactionDTO dto = new TransactionDTO();
        dto.setId(transaction.getId());
        dto.setAmount(transaction.getAmount());
        dto.setDate(transaction.getDate());
        dto.setStatus(transaction.getStatus().name()); // Convert enum to String
        dto.setCurrency(transaction.getCurrency());
        dto.setDescription(transaction.getDescription());
        dto.setUserId(transaction.getUserId());
        return dto;
    }

    public static Transaction fromDTO(TransactionDTO dto) {
        if (dto == null) return null;

        Transaction transaction = new Transaction();
        transaction.setId(dto.getId());
        transaction.setAmount(dto.getAmount());
        transaction.setDate(dto.getDate());
        transaction.setStatus(TransactionStatus.valueOf(dto.getStatus())); // Convert String to enum
        transaction.setCurrency(dto.getCurrency());
        transaction.setDescription(dto.getDescription());
        transaction.setUserId(dto.getUserId());
        return transaction;
    }
}