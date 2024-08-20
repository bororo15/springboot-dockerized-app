package com.example.project_ex1.controller;

import com.example.project_ex1.model.User;
import com.example.project_ex1.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private List<User> users = new ArrayList<>();
    private int nextId = 1;

    @Autowired
    ShopService shopService;

    @GetMapping("/testApi")
    public String testApi() {
        shopService.testApi();
        return "aaaa";
    }

    @GetMapping("/testName")
    public String testName(long id){
        return shopService.testName(id);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // POST 요청 (application/x-www-form-urlencoded)
    @PostMapping("/nameForm")
    public String getUserNamePostForm(@RequestParam("userId") long userId) {
        return shopService.testName(userId);
    }

    @PostMapping("/name")
    public String getUserNamePost(@RequestBody UserIdRequest request) {
        return shopService.testName(request.getUserId());
    }

    // UserIdRequest 내부 클래스 추가
    public static class UserIdRequest {
        private long userId;

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }
    }
    // PUT 요청
    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        user.setId(id);
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                users.set(i, user);
                return user;
            }
        }
        return null; // 사용자를 찾지 못한 경우
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
                break;
            }
        }
    }

    @PostMapping
    public ResponseEntity<Integer> createUser(@RequestBody User user) {
        int result = shopService.createUser(user);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = shopService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        User user = shopService.getUserById(userId);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Integer> updateUser(@PathVariable Long userId, @RequestBody User user) {
        user.setUserId(userId);
        int result = shopService.updateUser(user);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Integer> deleteUser(@PathVariable Long userId) {
        int result = shopService.deleteUser(userId);
        return ResponseEntity.ok(result);
    }
}