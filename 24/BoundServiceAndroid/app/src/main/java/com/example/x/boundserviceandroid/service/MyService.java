package com.example.x.boundserviceandroid.service;

/* Created by X on 12/10/2017.
* */

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.example.x.boundserviceandroid.model.MyPlayer;

public class MyService extends Service{
    private IBinder binder;
    private MyPlayer myPlayer;

    @Override
    public void onCreate() {
        super.onCreate();
        myPlayer = new MyPlayer(getApplicationContext());
        binder = new MyBinder();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        if (myPlayer != null)
            myPlayer.play();
        return binder;
    }

    public void fastForward() {
        if (myPlayer != null)
            myPlayer.fastForward();
    }
    @Override
    public boolean onUnbind(Intent intent) {
        if (myPlayer != null)
            myPlayer.stop();
        return super.onUnbind(intent);
    }

    public class MyBinder extends Binder {
        public MyService getMyService() {
            return MyService.this;
        }
    }
}
