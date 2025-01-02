package com.example.spring_boot_demo1.login.controller;

import com.example.spring_boot_demo1.login.service.LoginService;
import com.example.spring_boot_demo1.signup.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/users")

public class LoginController {
        @Autowired
        private LoginService loginService;
        @PostMapping("/validate")
        public ResponseEntity<Response<String>> validateUser(@RequestBody Map<String, String> request) {
            String email = request.get("email");
            String password = request.get("password");
            System.out.println(email);
            if (email == null || password == null) {
                return ResponseEntity.badRequest()
                        .body(new Response<>("Email or password cannot be null", null, false, HttpStatus.BAD_REQUEST.value()));
            }
            boolean isValid = loginService.validateUser(email, password);

            if (isValid) {
                return ResponseEntity.ok(new Response<>("User validation successful", "Valid user", true, HttpStatus.OK.value()));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(new Response<>("Invalid email or password", null, false, HttpStatus.UNAUTHORIZED.value()));
            }
        }
    }

