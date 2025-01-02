package com.example.spring_boot_demo1.signup.service;

import com.example.spring_boot_demo1.signup.repository.UserRepository;
import com.example.spring_boot_demo1.signup.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {

        return userRepository.findAll();
    }
    public User createUser(User user) {
        List<User> users = userRepository.findByEmail(user.getEmail());
        if (!users.isEmpty()) {
            throw new IllegalArgumentException("User with email " + user.getEmail() + " already exists.");
        }
        return userRepository.save(user);
    }
}
