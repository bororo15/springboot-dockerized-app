package com.example.project_ex1.repository;

import com.example.project_ex1.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ShopMapper {
    List<Map<String, Object>> selectSample(String id);
    public String GetNameWithID(long ID);

    int insertUser(User user);
    List<User> selectAllUsers();
    User selectUserById(Long userId);
    int updateUser(User user);
    int deleteUser(Long userId);

}