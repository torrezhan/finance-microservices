package ru.javabegin.finance.prioritysvc.service;

import ru.javabegin.finance.prioritysvc.model.Priority;
import ru.javabegin.finance.prioritysvc.repository.PriorityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PriorityService {
    private final PriorityRepository priorityRepository;

    public PriorityService(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    public List<Priority> getAllPriorities() {
        return priorityRepository.findAll();
    }

    public Optional<Priority> getPriorityById(Long id) {
        return priorityRepository.findById(id);
    }

    public Priority createPriority(Priority priority) {
        return priorityRepository.save(priority);
    }

    public boolean deletePriority(Long id) {
        if (priorityRepository.existsById(id)) {
            priorityRepository.deleteById(id);
            return true;
        }
        return false;
    }
}