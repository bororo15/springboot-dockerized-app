package com.example.project_ex1;

import com.example.project_ex1.repository.ShopMapper;
import com.example.project_ex1.service.ShopService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class ProjectEx1ApplicationTests {

    @Autowired
    ShopMapper shopMapper;

    @Autowired
    ShopService shopService;
    @Test
    void contextLoads() {
        String ret = shopMapper.GetNameWithID(1);

        System.out.println("aaa");

    }

}
