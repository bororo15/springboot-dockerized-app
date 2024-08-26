package com.example.project_ex1.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private Long userId;
    private String userName;
    private String userEmail;
    private String userPhoneNumber;
    private LocalDateTime regDt;
}
