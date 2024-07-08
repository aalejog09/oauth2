package com.api.resources.web.controllers.user;


import com.api.resources.dto.pagination.PaginationDTO;
import com.api.resources.services.interfaces.IUserService;
import com.api.resources.util.exceptions.ErrorDTO;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    IUserService userService;



    @ApiResponses({
            @ApiResponse(
                    responseCode="200",
                    content =@Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation= PaginationDTO.class),
                            examples = @ExampleObject(name="responseDTOExample",value="see PaginationDTO class for examples"))
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
    @GetMapping("/all/pageables")
    public ResponseEntity<PaginationDTO> getAllPageables( @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "4")  int elements) {
        return ResponseEntity.ok(this.userService.getAllUserListPageables(page,elements));
    }

}
