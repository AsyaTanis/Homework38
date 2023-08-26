package com.example.logging.mappers;

import org.mapstruct.Mapper;
import com.example.logging.dto.UserDTO;
import com.example.logging.security.AuthUser;
@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDto (AuthUser authUser);
    AuthUser toUser (UserDTO userDTO);
}
