package com.example.x.unboundserviceandroid.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.x.unboundserviceandroid.R;
import com.example.x.unboundserviceandroid.service.MyService;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnStart, btnStop;
    private Intent i = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControls();
        initEvents();
    }

    private void initEvents() {
        btnStop.setOnClickListener(this);
        btnStart.setOnClickListener(this);
    }

    private void initControls() {
        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStart:
                i = new Intent(this, MyService.class);
                startService(i);
                break;
            case R.id.btnStop:
                if (i != null)
                    stopService(i);
                break;
        }
    }
}
