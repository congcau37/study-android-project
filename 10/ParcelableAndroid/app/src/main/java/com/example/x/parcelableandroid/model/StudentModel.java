package com.example.x.parcelableandroid.model;

/* Created by X on 12/5/2017.
* */

import android.os.Parcel;
import android.os.Parcelable;

public class StudentModel implements Parcelable{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    protected StudentModel(Parcel in) {
        name = in.readString();
        age = in.readInt();
    }

    public StudentModel(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<StudentModel> CREATOR = new Creator<StudentModel>() {
        @Override
        public StudentModel createFromParcel(Parcel in) {
            return new StudentModel(in);
        }

        @Override
        public StudentModel[] newArray(int size) {
            return new StudentModel[size];
        }
    };
}
