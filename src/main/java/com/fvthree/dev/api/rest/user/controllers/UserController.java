package com.fvthree.dev.api.rest.user.controllers;

import com.fvthree.dev.api.rest.shared.CurrentUser;
import com.fvthree.dev.api.rest.shared.GenericResponse;
import com.fvthree.dev.api.rest.user.dto.UserDto;
import com.fvthree.dev.api.rest.user.entities.User;
import com.fvthree.dev.api.rest.user.services.UserService;
import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @PostMapping("${dev.url.register}")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public GenericResponse createUser(@Valid @RequestBody User user) {
        userService.save(user);
        return new GenericResponse("User saved!");
    }

    @GetMapping
    Page<UserDto> getUsers(@CurrentUser User loggedInUser, Pageable page) {
        return userService.getUsers(loggedInUser, page).map(UserDto::new);
    }

    @GetMapping("/{username}")
    UserDto getUserByName(@PathVariable String username) {
        User user = userService.getByUsername(username);
        return new UserDto(user);
    }
}
