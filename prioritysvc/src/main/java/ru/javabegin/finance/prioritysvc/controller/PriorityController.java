package ru.javabegin.finance.prioritysvc.controller;

import ru.javabegin.finance.prioritysvc.dto.PriorityDTO;
import ru.javabegin.finance.prioritysvc.mapper.PriorityMapper;
import ru.javabegin.finance.prioritysvc.service.PriorityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/priorities")
public class PriorityController {
    private final PriorityService priorityService;

    public PriorityController(PriorityService priorityService) {
        this.priorityService = priorityService;
    }

    @GetMapping
    public List<PriorityDTO> getAllPriorities() {
        return priorityService.getAllPriorities().stream()
                .map(PriorityMapper::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<PriorityDTO> createPriority(@RequestBody PriorityDTO priorityDTO) {
        var priority = PriorityMapper.fromDTO(priorityDTO);
        var savedPriority = priorityService.createPriority(priority);
        return ResponseEntity.ok(PriorityMapper.toDTO(savedPriority));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PriorityDTO> getPriorityById(@PathVariable Long id) {
        return priorityService.getPriorityById(id)
                .map(PriorityMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePriority(@PathVariable Long id) {
        if (priorityService.deletePriority(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}