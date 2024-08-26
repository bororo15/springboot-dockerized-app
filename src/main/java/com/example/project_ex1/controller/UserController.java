package com.example.project_ex1.controller;

import com.example.project_ex1.dto.*;
import com.example.project_ex1.model.User;
import com.example.project_ex1.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private ShopService shopService;

    @GetMapping("/testApi")
    public String testApi() {
        shopService.testApi();
        return "aaaa";
    }

    @GetMapping("/testName")
    public String testName(long id) {
        return shopService.testName(id);
    }

    @PostMapping("/nameForm")
    public String getUserNamePostForm(@RequestParam("userId") long userId) {
        return shopService.testName(userId);
    }

    @PostMapping("/name")
    public String getUserNamePost(@RequestBody UserIdRequestDto request) {
        return shopService.testName(request.getUserId());
    }

    @PostMapping
    public ResponseEntity<Integer> createUser(@RequestBody UserCreateRequestDto userDto) {
        User user = convertToUser(userDto);
        int result = shopService.createUser(user);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        List<User> users = shopService.getAllUsers();
        List<UserResponseDto> userDtos = users.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(userDtos);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable Long userId) {
        User user = shopService.getUserById(userId);
        return user != null ? ResponseEntity.ok(convertToDto(user)) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Integer> updateUser(@PathVariable Long userId, @RequestBody UserUpdateRequestDto userDto) {
        User user = convertToUser(userDto);
        user.setUserId(userId);
        int result = shopService.updateUser(user);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Integer> deleteUser(@PathVariable Long userId) {
        int result = shopService.deleteUser(userId);
        return ResponseEntity.ok(result);
    }

    // Helper methods for DTO conversion
    private User convertToUser(UserCreateRequestDto dto) {
        User user = new User();
        user.setUserName(dto.getUserName());
        user.setUserEmail(dto.getUserEmail());
        user.setUserPhoneNumber(dto.getUserPhoneNumber());
        return user;
    }

    private User convertToUser(UserUpdateRequestDto dto) {
        User user = new User();
        user.setUserName(dto.getUserName());
        user.setUserEmail(dto.getUserEmail());
        user.setUserPhoneNumber(dto.getUserPhoneNumber());
        return user;
    }

    private UserResponseDto convertToDto(User user) {
        return new UserResponseDto(
                user.getUserId(),
                user.getUserName(),
                user.getUserEmail(),
                user.getUserPhoneNumber(),
                user.getRegDt()
        );
    }
}