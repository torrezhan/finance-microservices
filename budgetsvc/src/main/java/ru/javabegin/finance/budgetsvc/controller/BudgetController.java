package ru.javabegin.finance.budgetsvc.controller;

import ru.javabegin.finance.budgetsvc.dto.BudgetDTO;
import ru.javabegin.finance.budgetsvc.mapper.BudgetMapper;
import ru.javabegin.finance.budgetsvc.service.BudgetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/budgets")
public class BudgetController {
    private final BudgetService budgetService;

    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @GetMapping
    public List<BudgetDTO> getAllBudgets() {
        return budgetService.getAllBudgets().stream()
                .map(BudgetMapper::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping("/create")
    public ResponseEntity<BudgetDTO> createBudget(@RequestBody BudgetDTO budgetDTO) {
        var budget = BudgetMapper.fromDTO(budgetDTO);
        var savedBudget = budgetService.createBudget(budget);
        return ResponseEntity.ok(BudgetMapper.toDTO(savedBudget));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BudgetDTO> getBudgetById(@PathVariable Long id) {
        return budgetService.getBudgetById(id)
                .map(BudgetMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBudget(@PathVariable Long id) {
        if (budgetService.deleteBudget(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}