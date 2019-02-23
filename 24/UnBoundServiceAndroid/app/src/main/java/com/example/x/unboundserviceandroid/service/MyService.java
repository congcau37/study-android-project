package com.example.x.unboundserviceandroid.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.example.x.unboundserviceandroid.model.MyPlayer;

public class MyService extends Service {
    private MyPlayer myPlayer;

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myPlayer = new MyPlayer(getApplicationContext());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (myPlayer != null)
            myPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (myPlayer != null)
            myPlayer.stop();
    }
}
