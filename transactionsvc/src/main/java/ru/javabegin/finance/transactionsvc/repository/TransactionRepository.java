package ru.javabegin.finance.transactionsvc.repository;

import ru.javabegin.finance.transactionsvc.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByUserId(Long userId);
}
