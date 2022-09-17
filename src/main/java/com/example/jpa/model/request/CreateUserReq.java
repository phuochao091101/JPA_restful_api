package com.example.jpa.model.request;


import lombok.*;
import javax.validation.constraints.*;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserReq {
    @NotNull(message = "Email is required")
    @NotEmpty(message = "Email is required")
    @Email(message = "Please provide a valid email")
    private String email;

    @Pattern(regexp="(09|01[2|6|8|9])+([0-9]{8})\\b", message = "Please provide a valid phone number")
    private String phone;

    @NotNull(message = "Full name is required")
    @NotEmpty(message = "Full name is required")
    private String fullName;

    @NotNull(message = "Password is required")
    @NotEmpty(message = "Password is required")
    @Size(min = 4, max = 20, message = "Password must be between 4 and 20 characters")
    private String password;


}
