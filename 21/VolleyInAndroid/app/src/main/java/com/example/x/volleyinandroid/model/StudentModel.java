package com.example.x.volleyinandroid.model;

/* Created by X on 12/8/2017.
* */

public class StudentModel {
    private int id;
    private String name;
    private String age;

    public StudentModel(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public StudentModel(int id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
