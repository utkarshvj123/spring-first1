package com.example.spring_boot_demo1.signup.controller;

import com.example.spring_boot_demo1.signup.response.Response;
import com.example.spring_boot_demo1.signup.service.UserService;
import com.example.spring_boot_demo1.signup.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public ResponseEntity<Response<User>> createUser(@RequestBody User user) {
        if (user == null ||
                user.getName() == null || user.getName().trim().isEmpty() ||
                user.getEmail() == null || user.getEmail().trim().isEmpty() ||
                user.getPassword() == null || user.getPassword().trim().isEmpty() ||
                user.getConfirmPassword() == null || user.getConfirmPassword().trim().isEmpty() ||
                user.getPhone() == null || user.getPhone().trim().isEmpty()) {
            // Return validation error response if any required field is null or empty
            Response<User> response = new Response<>("All fields are required and cannot be empty.", user, false, HttpStatus.BAD_REQUEST.value());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        try {
            User createdUser = userService.createUser(user);
            Response<User> response = new Response<>("User created successfully", createdUser, true, HttpStatus.CREATED.value());
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            Response<User> response = new Response<>(e.getMessage(), user, false, HttpStatus.BAD_REQUEST.value());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            Response<User> response = new Response<>("An unexpected error occurred.", user, false, HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
