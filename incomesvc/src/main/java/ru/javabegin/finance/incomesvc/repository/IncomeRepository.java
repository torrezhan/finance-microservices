package ru.javabegin.finance.incomesvc.repository;

import ru.javabegin.finance.incomesvc.model.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IncomeRepository extends JpaRepository<Income, Long> {
    List<Income> findByUserId(Long userId);
}
