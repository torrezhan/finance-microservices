package ru.javabegin.finance.prioritysvc.repository;

import ru.javabegin.finance.prioritysvc.model.Priority;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PriorityRepository extends JpaRepository<Priority, Long> {
    List<Priority> findByUserId(Long userId);
}
