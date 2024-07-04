package com.oauth.server.dto.token;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenResponseDTO {

    @Schema(description = "Access token", example = "eyJraWQiOiJjNzM0OTAzOC1iYWZiLTRmNjgtOTQ5ZC05NzAxNDY1YWQ0ZGIi")
    private String accessToken;
    @Schema(description = "Refresh token", example = "ayTU7La2g_DDgKD1MI0Kp4_j3hE9GkVDLjPZabZ8JXPr4XhhrJqe8sm4OwDLIgBORsefkviaF124etxzS3yH6V3sKffby8K8t2iuO3X09KFXT-73xnEIK2bgULkqpEdb")
    private String refreshToken;
    @Schema(description = "Token expiration time in seconds", example = "86400")
    private String tokenExpireTime;
}
