package com.example.project_ex1.model;

public class User {
    private int id;
    private String name;

    // 생성자
    public User() {}

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter와 Setter 메서드
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
