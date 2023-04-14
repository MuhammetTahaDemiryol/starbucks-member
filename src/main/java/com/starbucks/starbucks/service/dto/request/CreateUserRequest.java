package com.starbucks.starbucks.service.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {
    @NotBlank(message = "Name can not be null!!")
    private String name;
    @NotBlank(message = "Surname can not be null!!")
    private String surname;
    @NotBlank(message = "Identity number can not be null!!")
    @Length(max = 11,min = 11,message = "Identity number must be 11 character")
    private String identityNumber;
    private LocalDate birthDay;
}