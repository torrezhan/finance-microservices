package ru.javabegin.finance.usersvc.service;

import ru.javabegin.finance.usersvc.model.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserEntity registerUser(UserEntity user);
    Optional<UserEntity> getUserById(Long id);
    Optional<UserEntity> getUserByEmail(String email);
    List<UserEntity> getAllUsers();
    Optional<UserEntity> updateUser(Long id, UserEntity updatedUser);
    boolean deleteUser(Long id);
}
