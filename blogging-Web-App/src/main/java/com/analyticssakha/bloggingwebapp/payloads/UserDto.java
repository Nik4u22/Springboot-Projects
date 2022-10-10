package com.analyticssakha.bloggingwebapp.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private Integer id;
    @NotEmpty
    @Size(min = 4, message = "User Name must be at least 4 characters")
    private String name;
    @Email(message="Invalid email address")
    private String email;
    @NotEmpty
    @Size(min = 4, max = 10, message = "Password must be min 4 characters and max 10 characters")
    private String password;
    private String about;

}
