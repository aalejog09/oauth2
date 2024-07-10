package com.oauth.server.web.restcontroller;


import com.oauth.server.dto.token.RefreshTokenDTO;
import com.oauth.server.dto.token.TokenResponseDTO;
import com.oauth.server.dto.token.TokenRequestDTO;
import com.oauth.server.services.interfaces.ILoginService;
import com.oauth.server.util.documentation.SwaggerGenericResponses;
import com.oauth.server.util.exceptions.ErrorDTO;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin("*")
@RequestMapping("/login")
public class LoginController {

    @Autowired
    ILoginService loginService;

    @SwaggerGenericResponses
    @PostMapping("/token")
    public ResponseEntity<TokenResponseDTO> requestToken(@Valid @RequestBody TokenRequestDTO tokenRequestDTO){
        TokenResponseDTO response = loginService.getToken(tokenRequestDTO);
        return ResponseEntity.ok().body(response);
    }

    @SwaggerGenericResponses
    @PostMapping("/refresh")
    public ResponseEntity<TokenResponseDTO> refreshToken(@Valid @RequestBody RefreshTokenDTO request){
        TokenResponseDTO response = loginService.getRefreshToken(request);
        return ResponseEntity.ok().body(response);
    }
}

