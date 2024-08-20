package com.example.project_ex1.service;

import com.example.project_ex1.model.User;
import com.example.project_ex1.repository.ShopMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {

    private ShopMapper shopMapper;

    public ShopService(ShopMapper shopMapper) {
        this.shopMapper = shopMapper;
    }

    public void testApi() {
        shopMapper.selectSample("");
    }
    public String testName(long id){
        return this.shopMapper.GetNameWithID(id);
    }

    public int createUser(User user) {
        return shopMapper.insertUser(user);
    }

    public List<User> getAllUsers() {
        return shopMapper.selectAllUsers();
    }

    public User getUserById(Long userId) {
        return shopMapper.selectUserById(userId);
    }

    public int updateUser(User user) {
        return shopMapper.updateUser(user);
    }

    public int deleteUser(Long userId) {
        return shopMapper.deleteUser(userId);
    }
}