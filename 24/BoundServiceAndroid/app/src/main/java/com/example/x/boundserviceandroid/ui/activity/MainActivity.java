package com.example.x.boundserviceandroid.ui.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.x.boundserviceandroid.R;
import com.example.x.boundserviceandroid.service.MyService;

public class MainActivity extends AppCompatActivity {
    private MyService myService;
    private boolean isBound = false;
    private ServiceConnection connection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControls();
    }

    private void initControls() {
        connection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                MyService.MyBinder binder = (MyService.MyBinder) service;
                myService = binder.getMyService();
                isBound = true;
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                isBound = false;
            }
        };
    }

    public void handle(View view) {
        switch (view.getId()) {
            case R.id.btnStart:
                Intent i = new Intent(this, MyService.class);
                bindService(i, connection, Context.BIND_AUTO_CREATE);
                break;
            case R.id.btnStop:
                unbindService(connection);
                isBound = false;
                break;
            case R.id.btnFastfoward:
                if (isBound)
                    myService.fastForward();
                break;
        }
    }
}
