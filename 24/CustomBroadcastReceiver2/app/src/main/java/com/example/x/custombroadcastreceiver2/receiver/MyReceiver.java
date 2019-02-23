package com.example.x.custombroadcastreceiver2.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.x.custombroadcastreceiver2.config.common.Constants;

/* Created by X on 12/1/2017.
* */

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Constants.CUSTOM_BROADCAST)) {
            Bundle bd = intent.getExtras();
            if (bd != null)
                Toast.makeText(context, bd.getString("content"), Toast.LENGTH_SHORT).show();
        }
    }
}
