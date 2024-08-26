package com.example.project_ex1.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateRequestDto {
    private String userName;
    private String userEmail;
    private String userPhoneNumber;
}