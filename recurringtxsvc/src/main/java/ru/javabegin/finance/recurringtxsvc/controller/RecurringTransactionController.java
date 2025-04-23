package ru.javabegin.finance.recurringtxsvc.controller;

import ru.javabegin.finance.recurringtxsvc.dto.RecurringTransactionDTO;
import ru.javabegin.finance.recurringtxsvc.mapper.RecurringTransactionMapper;
import ru.javabegin.finance.recurringtxsvc.service.RecurringTransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/recurring-transactions")
public class RecurringTransactionController {
    private final RecurringTransactionService recurringTransactionService;

    public RecurringTransactionController(RecurringTransactionService recurringTransactionService) {
        this.recurringTransactionService = recurringTransactionService;
    }

    @GetMapping
    public List<RecurringTransactionDTO> getAllRecurringTransactions() {
        return recurringTransactionService.getAllRecurringTransactions().stream()
                .map(RecurringTransactionMapper::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<RecurringTransactionDTO> createRecurringTransaction(@RequestBody RecurringTransactionDTO recurringTransactionDTO) {
        var recurringTransaction = RecurringTransactionMapper.fromDTO(recurringTransactionDTO);
        var savedRecurringTransaction = recurringTransactionService.createRecurringTransaction(recurringTransaction);
        return ResponseEntity.ok(RecurringTransactionMapper.toDTO(savedRecurringTransaction));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecurringTransactionDTO> getRecurringTransactionById(@PathVariable Long id) {
        return recurringTransactionService.getRecurringTransactionById(id)
                .map(RecurringTransactionMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecurringTransaction(@PathVariable Long id) {
        if (recurringTransactionService.deleteRecurringTransaction(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}