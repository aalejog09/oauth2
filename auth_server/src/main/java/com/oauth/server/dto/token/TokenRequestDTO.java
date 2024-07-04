package com.oauth.server.dto.token;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenRequestDTO {

    @Schema(description = "Username", example = "admin@correo.com")
    @NotBlank(message = "Username cannot be null or blank.")
    String username;

    @Schema(description = "Password", example = "Secr3t")
    @Size(min=6, message = "Password cannot be less than 6 digits.")
    @NotBlank(message = "Password cannot be null or blank.")
    String password;
}
