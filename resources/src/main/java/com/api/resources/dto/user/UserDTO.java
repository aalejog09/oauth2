package com.api.resources.dto.user;

import com.api.resources.util.BooleanToSmallintConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {


    private String firstName;

    private String lastName;

    private String email;

    private String username;

    @Convert(converter = BooleanToSmallintConverter.class)
    private boolean enabled = false;


}
