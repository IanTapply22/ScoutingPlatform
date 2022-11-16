package me.iantapply.scoutingPlatform.dto.authentication;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import me.iantapply.scoutingPlatform.data.UserRoles;

import java.util.List;

@Data
public class UserResponseDTO {

    @ApiModelProperty(position = 0)
    private Integer id;
    @ApiModelProperty(position = 1)
    private String username;
    @ApiModelProperty(position = 2)
    private String email;
    @ApiModelProperty(position = 3)
    List<UserRoles> userRoles;

}
