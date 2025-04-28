package ru.javabegin.finance.authservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.javabegin.finance.authservice.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
} 