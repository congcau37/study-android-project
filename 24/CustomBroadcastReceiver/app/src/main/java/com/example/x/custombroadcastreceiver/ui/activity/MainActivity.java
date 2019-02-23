package com.example.x.custombroadcastreceiver.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.x.custombroadcastreceiver.R;
import com.example.x.custombroadcastreceiver.config.common.Constants;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendBroadcast(View view) {
        Intent i = new Intent(Constants.CUSTOM_BROADCAST);
        Bundle bd = new Bundle();
        bd.putString("content", "Hello World");
        i.putExtras(bd);
        sendBroadcast(i);
    }
}
