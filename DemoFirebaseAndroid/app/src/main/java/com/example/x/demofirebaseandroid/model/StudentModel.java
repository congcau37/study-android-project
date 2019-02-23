package com.example.x.demofirebaseandroid.model;

/* Created by X on 11/22/2017.
* */

public class StudentModel {
    private String name;
    private int age;
    private String key;

    public StudentModel() {
    }

    public StudentModel(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
