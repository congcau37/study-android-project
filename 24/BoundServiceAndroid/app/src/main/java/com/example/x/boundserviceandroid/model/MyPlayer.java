package com.example.x.boundserviceandroid.model;

/* Created by X on 12/10/2017.
* */

import android.content.Context;
import android.media.MediaPlayer;

import com.example.x.boundserviceandroid.R;

public class MyPlayer {
    private MediaPlayer player;

    public MyPlayer(Context context) {
        player = MediaPlayer.create(context, R.raw.choemgananhthemchutnua);
    }

    public void play() {
        if (player != null)
            player.start();
    }

    public void stop() {
        if (player != null)
            player.stop();
    }

    public void fastForward() {
        player.seekTo(50000);
    }
}
