package com.example.spring_boot_demo1.login.repository;

import com.example.spring_boot_demo1.login.controller.Login;
import com.example.spring_boot_demo1.signup.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmailAndPassword(String email, String password);
}
