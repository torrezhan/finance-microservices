package ru.javabegin.finance.incomesvc.controller;

import ru.javabegin.finance.incomesvc.dto.IncomeDTO;
import ru.javabegin.finance.incomesvc.mapper.IncomeMapper;
import ru.javabegin.finance.incomesvc.service.IncomeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/incomes")
public class IncomeController {
    private final IncomeService incomeService;

    public IncomeController(IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    @GetMapping
    public List<IncomeDTO> getAllIncomes() {
        return incomeService.getAllIncomes().stream()
                .map(IncomeMapper::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<IncomeDTO> createIncome(@RequestBody IncomeDTO incomeDTO) {
        var income = IncomeMapper.fromDTO(incomeDTO);
        var savedIncome = incomeService.createIncome(income);
        return ResponseEntity.ok(IncomeMapper.toDTO(savedIncome));
    }

    @GetMapping("/{id}")
    public ResponseEntity<IncomeDTO> getIncomeById(@PathVariable Long id) {
        return incomeService.getIncomeById(id)
                .map(IncomeMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIncome(@PathVariable Long id) {
        if (incomeService.deleteIncome(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}