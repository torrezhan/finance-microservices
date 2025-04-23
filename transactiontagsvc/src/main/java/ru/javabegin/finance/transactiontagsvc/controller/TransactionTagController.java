package ru.javabegin.finance.transactiontagsvc.controller;

import ru.javabegin.finance.transactiontagsvc.dto.TransactionTagDTO;
import ru.javabegin.finance.transactiontagsvc.mapper.TransactionTagMapper;
import ru.javabegin.finance.transactiontagsvc.service.TransactionTagService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/transaction-tags")
public class TransactionTagController {
    private final TransactionTagService transactionTagService;

    public TransactionTagController(TransactionTagService transactionTagService) {
        this.transactionTagService = transactionTagService;
    }

    @GetMapping
    public List<TransactionTagDTO> getAllTransactionTags() {
        return transactionTagService.getAllTransactionTags().stream()
                .map(TransactionTagMapper::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<TransactionTagDTO> createTransactionTag(@RequestBody TransactionTagDTO transactionTagDTO) {
        var transactionTag = TransactionTagMapper.fromDTO(transactionTagDTO);
        var savedTransactionTag = transactionTagService.createTransactionTag(transactionTag);
        return ResponseEntity.ok(TransactionTagMapper.toDTO(savedTransactionTag));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionTagDTO> getTransactionTagById(@PathVariable Long id) {
        return transactionTagService.getTransactionTagById(id)
                .map(TransactionTagMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransactionTag(@PathVariable Long id) {
        if (transactionTagService.deleteTransactionTag(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}