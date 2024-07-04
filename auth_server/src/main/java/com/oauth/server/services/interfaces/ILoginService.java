package com.oauth.server.services.interfaces;


import com.oauth.server.dto.token.RefreshTokenDTO;
import com.oauth.server.dto.token.TokenResponseDTO;
import com.oauth.server.dto.token.TokenRequestDTO;

public interface ILoginService {

    public TokenResponseDTO getToken(TokenRequestDTO userRequest);

    public TokenResponseDTO getRefreshToken(RefreshTokenDTO request);
}
