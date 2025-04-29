package ru.javabegin.finance.prioritysvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {
    "ru.javabegin.finance.prioritysvc",
    "ru.javabegin.finance.commonconfig"
})
public class PriorityServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PriorityServiceApplication.class, args);
    }
} 