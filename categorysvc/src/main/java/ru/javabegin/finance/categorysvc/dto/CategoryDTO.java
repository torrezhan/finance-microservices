package ru.javabegin.finance.categorysvc.dto;

public class CategoryDTO {
    private Long id;
    private String name;
    private String color;
    private Long userId;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
}