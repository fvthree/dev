package com.fvthree.dev.api.rest.login;

import com.fvthree.dev.api.rest.shared.CurrentUser;
import com.fvthree.dev.api.rest.user.dto.UserDto;
import com.fvthree.dev.api.rest.user.entities.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping("/api/login")
    UserDto handleLogin(@CurrentUser User loggedInUser) {
        return new UserDto(loggedInUser);
    }
}
