package ru.javabegin.finance.prioritysvc.mapper;

import ru.javabegin.finance.prioritysvc.dto.PriorityDTO;
import ru.javabegin.finance.prioritysvc.model.Priority;

public class PriorityMapper {
    public static PriorityDTO toDTO(Priority priority) {
        if (priority == null) return null;

        PriorityDTO dto = new PriorityDTO();
        dto.setId(priority.getId());
        dto.setName(priority.getName());
        dto.setColor(priority.getColor());
        dto.setUserId(priority.getUserId());
        return dto;
    }

    public static Priority fromDTO(PriorityDTO dto) {
        if (dto == null) return null;

        Priority priority = new Priority();
        priority.setId(dto.getId());
        priority.setName(dto.getName());
        priority.setColor(dto.getColor());
        priority.setUserId(dto.getUserId());
        return priority;
    }
}