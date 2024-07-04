package com.oauth.server.web.restcontroller;


import com.oauth.server.dto.token.RefreshTokenDTO;
import com.oauth.server.dto.token.TokenResponseDTO;
import com.oauth.server.dto.token.TokenRequestDTO;
import com.oauth.server.services.interfaces.ILoginService;
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


    @PostMapping("/token")
    @ApiResponses({
            @ApiResponse(
                    responseCode="200",
                    content =@Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation= TokenResponseDTO.class),
                            examples = @ExampleObject(name="responseDTOExample",value="see TokenResponseDTO class for examples"))
            ),
            @ApiResponse(
                    responseCode = "400",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ErrorDTO.class),
                            examples = @ExampleObject(name="ErrorDTOExample",value="see ErrorDTO class for examples")
                    )
            )
    })
    public ResponseEntity<?> requestToken(@Valid @RequestBody TokenRequestDTO tokenRequestDTO){
        log.info("userDataRq: {}",tokenRequestDTO);
        TokenResponseDTO response = loginService.getToken(tokenRequestDTO);
        log.info("response= {}",response);
        return ResponseEntity.ok().body(response);
    }


    @ApiResponses({
            @ApiResponse(
                    responseCode="200",
                    content =@Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation= TokenResponseDTO.class),
                            examples = @ExampleObject(name="responseDTOExample",value="see TokenResponseDTO class for examples"))
            ),
            @ApiResponse(
                    responseCode = "400",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ErrorDTO.class),
                            examples = @ExampleObject(name="ErrorDTOExample",value="see ErrorDTO class for examples")
                    )
            )
    })
    @PostMapping("/refresh")
    public ResponseEntity<TokenResponseDTO> refreshToken(@Valid @RequestBody RefreshTokenDTO request){
        log.info("refreshToken: {}",request);
        TokenResponseDTO response = loginService.getRefreshToken(request);
        log.info("response: {}",response);
        return ResponseEntity.ok().body(response);
    }



}

