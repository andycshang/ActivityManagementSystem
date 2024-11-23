package com.activity.DTO.user;

import com.activity.entity.user.User;
import lombok.Data;


@Data
public class UserDTO {
    private Integer id;
    private String name;
    private Integer permissionLevel;


    public static UserDTO build(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setPermissionLevel(user.getAuthorityGroup().getPermissionLevel());
        return userDTO;
    }
    public static User parse(UserDTO userDTO){
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        return user;
    }

}
