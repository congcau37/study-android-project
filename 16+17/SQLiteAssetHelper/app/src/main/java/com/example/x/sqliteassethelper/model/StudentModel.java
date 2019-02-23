package com.example.x.sqliteassethelper.model;

/* Created by X on 12/1/2017.
* */

public class StudentModel {
    private String name;
    private int age;
    private int id;

    public StudentModel(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public StudentModel(int id, String name, int age) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
