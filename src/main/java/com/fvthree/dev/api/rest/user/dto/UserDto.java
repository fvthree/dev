package com.fvthree.dev.api.rest.user.dto;

import com.fvthree.dev.api.rest.user.entities.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
    private long id;
    private String username;
    private String displayName;
    private String image;

    public UserDto(User user) {
        this.setId(user.getId());
        this.setUsername(user.getUsername());
        this.setDisplayName(user.getDisplayName());
        this.setImage(user.getImage());
    }
}
