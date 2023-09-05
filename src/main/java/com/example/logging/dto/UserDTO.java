package com.example.logging.dto;
import com.example.logging.model.Role;
import lombok.*;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private long id;
    private String username;
    private String password;
    private Role role;
    private boolean enabled;
}
