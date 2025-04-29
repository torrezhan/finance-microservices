package ru.javabegin.finance.categorysvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {
    "ru.javabegin.finance.categorysvc",
    "ru.javabegin.finance.commonconfig"
})
public class CategoryServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CategoryServiceApplication.class, args);
    }
} 