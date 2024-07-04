package com.oauth.server.dto.token;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RefreshTokenDTO {

    @NotBlank(message = "RefreshToken cannot be null or blank.")
    @Size(min=100, message = "RefreshToken cannot be less than 100 digits.")
    String refreshToken;

}
