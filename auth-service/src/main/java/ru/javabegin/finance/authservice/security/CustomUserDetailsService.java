package ru.javabegin.finance.authservice.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.javabegin.finance.authservice.entity.User;
import ru.javabegin.finance.authservice.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword()) // пароль должен быть уже захеширован
                .authorities(
                        user.getRoles().stream()  // если roles - это List<String>
                                .map(role -> "ROLE_" + role)
                                .toArray(String[]::new)
                )
                .accountLocked(false)
                .disabled(!user.isEnabled())
                .build();
    }
}
