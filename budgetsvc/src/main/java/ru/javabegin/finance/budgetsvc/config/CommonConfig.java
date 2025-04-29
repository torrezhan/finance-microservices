package ru.javabegin.finance.budgetsvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.javabegin.finance.commonconfig.security.JwtConfig;

@Configuration
@Import(JwtConfig.class)
public class CommonConfig {
} 