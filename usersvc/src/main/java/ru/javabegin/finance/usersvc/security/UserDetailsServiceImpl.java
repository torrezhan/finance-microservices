package ru.javabegin.finance.usersvc.security;

import org.springframework.stereotype.Service;
import ru.javabegin.finance.usersvc.model.UserEntity;
import ru.javabegin.finance.usersvc.repository.UserRepository;
import ru.javabegin.finance.usersvc.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity registerUser(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<UserEntity> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<UserEntity> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserEntity> updateUser(Long id, UserEntity updatedUser) {
        return userRepository.findById(id).map(existingUser -> {
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPassword(updatedUser.getPassword());
            return userRepository.save(existingUser);
        });
    }

    @Override
    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
