package com.fvthree.dev.api.rest.user.services;

import com.fvthree.dev.api.rest.user.entities.User;
import com.fvthree.dev.api.rest.user.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        super();
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User save(User user) {
        User usr = userRepository.findByUsername(user.getUsername());
        if (usr != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    String.format("User with username %s already exists", user.getUsername()));
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
