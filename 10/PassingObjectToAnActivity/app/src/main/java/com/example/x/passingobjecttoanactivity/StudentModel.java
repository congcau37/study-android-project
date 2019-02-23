package com.example.x.passingobjecttoanactivity;

/* Created by X on 12/5/2017.
* */

import java.io.Serializable;

public class StudentModel implements Serializable{
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
