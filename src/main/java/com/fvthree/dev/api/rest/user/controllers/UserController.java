package com.fvthree.dev.api.rest.user.controllers;

import com.fvthree.dev.api.rest.shared.GenericResponse;
import com.fvthree.dev.api.rest.user.entities.User;
import com.fvthree.dev.api.rest.user.services.UserService;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public GenericResponse createUser(@Valid @RequestBody User user) {
        userService.save(user);
        return new GenericResponse("User saved!");
    }
}
