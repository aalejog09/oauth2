package com.oauth.server.persistence.mapper;

import com.oauth.server.dto.token.OriginalTokenResponse;
import com.oauth.server.dto.token.TokenResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring")
public interface TokenMapper {

    @Mappings({
            @Mapping( source = "access_token", target = "accessToken"),
            @Mapping( source = "refresh_token", target = "refreshToken"),
            @Mapping( source = "expires_in", target = "tokenExpireTime")
    })
    TokenResponseDTO mapTokenDTO(OriginalTokenResponse originalTokenResponse);

}