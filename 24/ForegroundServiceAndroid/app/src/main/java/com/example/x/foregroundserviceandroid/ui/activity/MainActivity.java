package com.example.x.foregroundserviceandroid.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.x.foregroundserviceandroid.R;
import com.example.x.foregroundserviceandroid.config.common.Constants;
import com.example.x.foregroundserviceandroid.service.ForegroundService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void handle(View view) {
        switch (view.getId()) {
            case R.id.btnStart:
                Intent startIntent = new Intent(this, ForegroundService.class);
                startIntent.setAction(Constants.ACTION.STARTFOREGROUND_ACTION);
                startService(startIntent);
                break;
            case R.id.btnStop:
                Intent stopService = new Intent(this, ForegroundService.class);
                stopService.setAction(Constants.ACTION.STOPFOREGROUND_ACTION);
                startService(stopService);
                break;
        }
    }
}
