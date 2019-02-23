package com.example.x.foregroundserviceandroid.model;

/* Created by X on 12/10/2017.
* */

import android.content.Context;
import android.media.MediaPlayer;

import com.example.x.foregroundserviceandroid.R;

public class MyPlayer {
    private MediaPlayer mediaPlayer;

    public MyPlayer(Context context) {
        mediaPlayer = MediaPlayer.create(context, R.raw.choemgananhthemchutnua);
    }

    public void play() {
        if (mediaPlayer != null)
            mediaPlayer.start();
    }

    public void stop() {
        if (mediaPlayer != null)
            mediaPlayer.stop();
    }

}
