package com.starbucks.starbucks.service.dto.response;

import com.starbucks.starbucks.entity.enums.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetAllUsersResponse {
    private int id;
    private String name;
    private String surname;
    private String identityNumber;
    private LocalDate birthDay;
    @Enumerated(EnumType.STRING)
    private Role role;
}