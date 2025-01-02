package com.example.spring_boot_demo1.signup.repository;

import com.example.spring_boot_demo1.signup.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByEmail(String email);
}

