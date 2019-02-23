package com.example.x.intenttraining.model;

import java.io.Serializable;

/* Created by X on 11/10/2017.
* */

public class StudentModel implements Serializable {
    private String name;
    private int age;

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
}
