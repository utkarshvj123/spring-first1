package com.example.spring_boot_demo1.login.service;

import com.example.spring_boot_demo1.login.repository.LoginRepository;
import com.example.spring_boot_demo1.signup.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;
    public boolean validateUser(String email, String password) {
        Optional<User> user = loginRepository.findByEmailAndPassword(email, password);
        return user.isPresent();
    }
}
