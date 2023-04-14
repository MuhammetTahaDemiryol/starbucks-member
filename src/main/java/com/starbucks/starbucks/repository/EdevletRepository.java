package com.starbucks.starbucks.repository;

import com.starbucks.starbucks.entity.Edevlet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface EdevletRepository extends JpaRepository<Edevlet,Integer> {
    boolean existsByNameAndSurnameAndIdentityNumberAndBirthDay(String  name, String surName, String identityNumber
            , LocalDate birthDay);
}