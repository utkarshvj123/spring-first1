package com.example.spring_boot_demo1.signup.repository;

import com.example.spring_boot_demo1.signup.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findByEmail(String email);
}

