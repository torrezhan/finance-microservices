package ru.javabegin.finance.recurringtxsvc.service;

import ru.javabegin.finance.recurringtxsvc.model.RecurringTransaction;
import ru.javabegin.finance.recurringtxsvc.repository.RecurringTransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecurringTransactionService {
    private final RecurringTransactionRepository recurringTransactionRepository;

    public RecurringTransactionService(RecurringTransactionRepository recurringTransactionRepository) {
        this.recurringTransactionRepository = recurringTransactionRepository;
    }

    public List<RecurringTransaction> getAllRecurringTransactions() {
        return recurringTransactionRepository.findAll();
    }

    public Optional<RecurringTransaction> getRecurringTransactionById(Long id) {
        return recurringTransactionRepository.findById(id);
    }

    public RecurringTransaction createRecurringTransaction(RecurringTransaction recurringTransaction) {
        return recurringTransactionRepository.save(recurringTransaction);
    }

    public boolean deleteRecurringTransaction(Long id) {
        if (recurringTransactionRepository.existsById(id)) {
            recurringTransactionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}