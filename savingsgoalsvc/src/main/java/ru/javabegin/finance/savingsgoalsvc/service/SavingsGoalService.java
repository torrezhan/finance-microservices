package ru.javabegin.finance.savingsgoalsvc.service;

import ru.javabegin.finance.savingsgoalsvc.model.SavingsGoal;
import ru.javabegin.finance.savingsgoalsvc.repository.SavingsGoalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SavingsGoalService {
    private final SavingsGoalRepository savingsGoalRepository;

    public SavingsGoalService(SavingsGoalRepository savingsGoalRepository) {
        this.savingsGoalRepository = savingsGoalRepository;
    }

    public List<SavingsGoal> getAllSavingsGoals() {
        return savingsGoalRepository.findAll();
    }

    public Optional<SavingsGoal> getSavingsGoalById(Long id) {
        return savingsGoalRepository.findById(id);
    }

    public SavingsGoal createSavingsGoal(SavingsGoal savingsGoal) {
        return savingsGoalRepository.save(savingsGoal);
    }

    public boolean deleteSavingsGoal(Long id) {
        if (savingsGoalRepository.existsById(id)) {
            savingsGoalRepository.deleteById(id);
            return true;
        }
        return false;
    }
}