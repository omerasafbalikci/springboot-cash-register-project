package com.toyota.usermanagementservice.dto.requests;

import com.toyota.usermanagementservice.domain.Gender;
import com.toyota.usermanagementservice.domain.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {
    @NotNull(message = "Id must not be null")
    private Long id;
    private String firstName;

    private String lastName;

    private String username;
    @Email(message = "It must be a valid email")
    private String email;
    @Size(min = 8, message = "Password must have at least 8 characters")
    private String password;
    @Size(min = 1, message = "User must have at least one role")
    private Set<Role> roles;
    private Gender gender;
}
