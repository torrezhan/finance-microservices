package ru.javabegin.finance.transactiontagsvc.mapper;

import ru.javabegin.finance.transactiontagsvc.dto.TransactionTagDTO;
import ru.javabegin.finance.transactiontagsvc.model.TransactionTag;

public class TransactionTagMapper {
    public static TransactionTagDTO toDTO(TransactionTag transactionTag) {
        if (transactionTag == null) return null;

        TransactionTagDTO dto = new TransactionTagDTO();
        dto.setId(transactionTag.getId());
        dto.setName(transactionTag.getName());
        dto.setDescription(transactionTag.getDescription());
        dto.setUserId(transactionTag.getUserId());
        return dto;
    }

    public static TransactionTag fromDTO(TransactionTagDTO dto) {
        if (dto == null) return null;

        TransactionTag transactionTag = new TransactionTag();
        transactionTag.setId(dto.getId());
        transactionTag.setName(dto.getName());
        transactionTag.setDescription(dto.getDescription());
        transactionTag.setUserId(dto.getUserId());
        return transactionTag;
    }
}