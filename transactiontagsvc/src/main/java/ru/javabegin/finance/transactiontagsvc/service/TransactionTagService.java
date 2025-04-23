package ru.javabegin.finance.transactiontagsvc.service;

import ru.javabegin.finance.transactiontagsvc.model.TransactionTag;
import ru.javabegin.finance.transactiontagsvc.repository.TransactionTagRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionTagService {
    private final TransactionTagRepository transactionTagRepository;

    public TransactionTagService(TransactionTagRepository transactionTagRepository) {
        this.transactionTagRepository = transactionTagRepository;
    }

    public List<TransactionTag> getAllTransactionTags() {
        return transactionTagRepository.findAll();
    }

    public Optional<TransactionTag> getTransactionTagById(Long id) {
        return transactionTagRepository.findById(id);
    }

    public TransactionTag createTransactionTag(TransactionTag transactionTag) {
        return transactionTagRepository.save(transactionTag);
    }

    public boolean deleteTransactionTag(Long id) {
        if (transactionTagRepository.existsById(id)) {
            transactionTagRepository.deleteById(id);
            return true;
        }
        return false;
    }
}