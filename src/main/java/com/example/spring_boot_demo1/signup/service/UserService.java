package com.example.spring_boot_demo1.signup.service;

import com.example.spring_boot_demo1.signup.entity.UserEntity;
import com.example.spring_boot_demo1.signup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }
    public UserEntity createUser(UserEntity userEntity) {
        List<UserEntity> userEntities = userRepository.findByEmail(userEntity.getEmail());
        if (!userEntities.isEmpty()) {
            throw new IllegalArgumentException("User with email " + userEntity.getEmail() + " already exists.");
        }
        return userRepository.save(userEntity);
    }
}
