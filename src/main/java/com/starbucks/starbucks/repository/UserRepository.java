package com.starbucks.starbucks.repository;

import com.starbucks.starbucks.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    boolean existsByIdentityNumber(String  identityNumber);
}