package ru.javabegin.finance.incomesvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {
    "ru.javabegin.finance.incomesvc",
    "ru.javabegin.finance.commonconfig"
})
public class IncomeServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(IncomeServiceApplication.class, args);
    }
} 