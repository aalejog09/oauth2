package com.api.resources.persistence.mapper;

import com.api.resources.dto.user.UserDTO;
import com.api.resources.persistence.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;


@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
            @Mapping( source = "username", target = "username"),
            @Mapping( source = "firstName", target = "firstName"),
            @Mapping( source = "lastName", target = "lastName"),
            @Mapping( source = "email", target = "email"),
            @Mapping( source = "enabled", target = "enabled")
    })
    UserDTO mapUserDTO(User tokenResponse);

    List<UserDTO> mapUserDTOList(List<User> users);

}