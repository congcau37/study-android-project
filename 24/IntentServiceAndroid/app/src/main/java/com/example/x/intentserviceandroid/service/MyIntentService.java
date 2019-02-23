package com.example.x.intentserviceandroid.service;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;

import com.example.x.intentserviceandroid.config.common.Constants;


public class MyIntentService extends IntentService {
    public static boolean shouldContinue = true;

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Intent i1 = new Intent(Constants.MY_ACTION);
        Bundle bd = new Bundle();
        for (int i = 0; i < 100; i++) {
            if (!shouldContinue) {
                stopSelf();
                return;
            }
            bd.putString("percent",  String.valueOf(i + 1));
            i1.putExtras(bd);
            sendBroadcast(i1);
            SystemClock.sleep(100);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
