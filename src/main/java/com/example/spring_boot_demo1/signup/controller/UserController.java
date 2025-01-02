package com.example.spring_boot_demo1.signup.controller;

import com.example.spring_boot_demo1.signup.entity.UserEntity;
import com.example.spring_boot_demo1.signup.response.Response;
import com.example.spring_boot_demo1.signup.service.UserService;
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
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public ResponseEntity<Response<UserEntity>> createUser(@RequestBody UserEntity userEntity) {
        if (userEntity == null ||
                userEntity.getName() == null || userEntity.getName().trim().isEmpty() ||
                userEntity.getEmail() == null || userEntity.getEmail().trim().isEmpty() ||
                userEntity.getPassword() == null || userEntity.getPassword().trim().isEmpty() ||
                userEntity.getConfirmPassword() == null || userEntity.getConfirmPassword().trim().isEmpty() ||
                userEntity.getPhone() == null || userEntity.getPhone().trim().isEmpty()) {
            // Return validation error response if any required field is null or empty
            Response<UserEntity> response = new Response<>("All fields are required and cannot be empty.", userEntity, false, HttpStatus.BAD_REQUEST.value());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        try {
            UserEntity createdUserEntity = userService.createUser(userEntity);
            Response<UserEntity> response = new Response<>("User created successfully", createdUserEntity, true, HttpStatus.CREATED.value());
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            Response<UserEntity> response = new Response<>(e.getMessage(), userEntity, false, HttpStatus.BAD_REQUEST.value());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            Response<UserEntity> response = new Response<>("An unexpected error occurred.", userEntity, false, HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
