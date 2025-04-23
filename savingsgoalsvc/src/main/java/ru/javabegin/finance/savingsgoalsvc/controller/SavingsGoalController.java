package ru.javabegin.finance.savingsgoalsvc.controller;

import ru.javabegin.finance.savingsgoalsvc.dto.SavingsGoalDTO;
import ru.javabegin.finance.savingsgoalsvc.mapper.SavingsGoalMapper;
import ru.javabegin.finance.savingsgoalsvc.service.SavingsGoalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/savings-goals")
public class SavingsGoalController {
    private final SavingsGoalService savingsGoalService;

    public SavingsGoalController(SavingsGoalService savingsGoalService) {
        this.savingsGoalService = savingsGoalService;
    }

    @GetMapping
    public List<SavingsGoalDTO> getAllSavingsGoals() {
        return savingsGoalService.getAllSavingsGoals().stream()
                .map(SavingsGoalMapper::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<SavingsGoalDTO> createSavingsGoal(@RequestBody SavingsGoalDTO savingsGoalDTO) {
        var savingsGoal = SavingsGoalMapper.fromDTO(savingsGoalDTO);
        var savedSavingsGoal = savingsGoalService.createSavingsGoal(savingsGoal);
        return ResponseEntity.ok(SavingsGoalMapper.toDTO(savedSavingsGoal));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SavingsGoalDTO> getSavingsGoalById(@PathVariable Long id) {
        return savingsGoalService.getSavingsGoalById(id)
                .map(SavingsGoalMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSavingsGoal(@PathVariable Long id) {
        if (savingsGoalService.deleteSavingsGoal(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}