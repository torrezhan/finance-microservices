package ru.javabegin.finance.savingsgoalsvc.repository;

import ru.javabegin.finance.savingsgoalsvc.model.SavingsGoal;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SavingsGoalRepository extends JpaRepository<SavingsGoal, Long> {
    List<SavingsGoal> findByUserId(Long userId);
}
