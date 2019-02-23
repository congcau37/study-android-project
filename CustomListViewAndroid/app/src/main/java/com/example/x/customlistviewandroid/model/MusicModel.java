package com.example.x.customlistviewandroid.model;

/**
 * Created by X on 11/6/2017.
 **/

public class MusicModel {
    private String name;
    private String singer;

    public MusicModel(String name, String singer) {
        this.name = name;
        this.singer = singer;
    }

    public String getName() {
        return name;
    }

    public String getSinger() {
        return singer;
    }
}
