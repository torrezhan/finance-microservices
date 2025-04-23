package ru.javabegin.finance.budgetsvc.repository;

import ru.javabegin.finance.budgetsvc.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BudgetRepository extends JpaRepository<Budget, Long> {
    List<Budget> findByUserId(Long userId);
}
