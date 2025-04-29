package ru.javabegin.finance.savingsgoalsvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {
    "ru.javabegin.finance.savingsgoalsvc",
    "ru.javabegin.finance.commonconfig"
})
public class SavingsGoalServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SavingsGoalServiceApplication.class, args);
    }
} 