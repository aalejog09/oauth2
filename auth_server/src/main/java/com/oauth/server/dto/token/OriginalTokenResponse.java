package com.oauth.server.dto.token;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OriginalTokenResponse {

    private String access_token;
    private String refresh_token;
    private String id_token;
    private String token_type;
    private String expires_in;

}
