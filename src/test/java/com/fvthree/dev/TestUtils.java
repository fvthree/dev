package com.fvthree.dev;

import com.fvthree.dev.api.rest.user.entities.User;

public class TestUtils {

    public static User createValidUser() {
        User user = new User();
        user.setDisplayName("TestUser");
        user.setImage("test-image.jpg");
        user.setPassword("password");
        return user;
    }

    public static User createUser(String username) {
        User user = createValidUser();
        user.setUsername(username);
        return user;
    }
}
