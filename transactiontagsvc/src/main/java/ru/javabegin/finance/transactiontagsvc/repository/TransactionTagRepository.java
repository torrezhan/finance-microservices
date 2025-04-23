package ru.javabegin.finance.transactiontagsvc.repository;

import ru.javabegin.finance.transactiontagsvc.model.TransactionTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionTagRepository extends JpaRepository<TransactionTag, Long> {
}
