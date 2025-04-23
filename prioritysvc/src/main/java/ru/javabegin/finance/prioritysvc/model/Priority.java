package ru.javabegin.finance.prioritysvc.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "priorities")
@Data
public class Priority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId; // Replace User reference with userId

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String color;
}