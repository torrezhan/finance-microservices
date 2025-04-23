package ru.javabegin.finance.categorysvc.repository;

import ru.javabegin.finance.categorysvc.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}