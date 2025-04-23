package ru.javabegin.finance.usersvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.javabegin.finance.usersvc.model.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
}
