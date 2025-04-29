package ru.javabegin.finance.budgetsvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {
    "ru.javabegin.finance.budgetsvc",
    "ru.javabegin.finance.commonconfig"
})
public class BudgetsvcApplication {
    public static void main(String[] args) {
        SpringApplication.run(BudgetsvcApplication.class, args);
    }
}