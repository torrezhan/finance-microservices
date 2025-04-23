package ru.javabegin.finance.categorysvc.mapper;

import ru.javabegin.finance.categorysvc.dto.CategoryDTO;
import ru.javabegin.finance.categorysvc.model.Category;

public class CategoryMapper {
    public static CategoryDTO toDTO(Category category) {
        if (category == null) return null;

        CategoryDTO dto = new CategoryDTO();
        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setColor(category.getColor());
        dto.setUserId(category.getUserId());
        return dto;
    }

    public static Category fromDTO(CategoryDTO dto) {
        if (dto == null) return null;

        Category category = new Category();
        category.setId(dto.getId());
        category.setName(dto.getName());
        category.setColor(dto.getColor());
        category.setUserId(dto.getUserId());
        return category;
    }
}