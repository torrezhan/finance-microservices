package ru.javabegin.finance.recurringtxsvc.repository;

import ru.javabegin.finance.recurringtxsvc.model.RecurringTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RecurringTransactionRepository extends JpaRepository<RecurringTransaction, Long> {
    List<RecurringTransaction> findByUserId(Long userId);
}
