package ru.javabegin.finance.authservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.javabegin.finance.authservice.dto.UserDTO;
import ru.javabegin.finance.authservice.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "password", ignore = true)
    UserDTO toDTO(User user);

    User toEntity(UserDTO userDTO);
} 