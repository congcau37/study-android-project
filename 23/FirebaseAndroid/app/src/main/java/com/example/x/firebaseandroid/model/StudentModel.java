package com.example.x.firebaseandroid.model;

/* Created by X on 12/2/2017.
* */

public class StudentModel {
    private String name;
    private int age;
    private String key;

    public StudentModel(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public StudentModel() {
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
