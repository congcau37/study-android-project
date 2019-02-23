package com.example.x.intentserviceandroid.ui.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.x.intentserviceandroid.R;
import com.example.x.intentserviceandroid.config.common.Constants;
import com.example.x.intentserviceandroid.service.MyIntentService;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ProgressBar progressBar;
    private TextView txtPercent;
    private Button btnStart, btnStop;
    private BroadcastReceiver receiver = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControls();
        initEvents();
    }

    private void initEvents() {
        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);
        receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals(Constants.MY_ACTION)) {
                    Bundle bd = intent.getExtras();
                    if (bd != null) {
                        String percent = bd.getString("percent", "");
                        new ShowProgressBarTask().execute(percent);
                    }
                }
            }
        };

        IntentFilter filter = new IntentFilter(Constants.MY_ACTION);
        registerReceiver(receiver, filter);
    }

    private class ShowProgressBarTask extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            publishProgress(strings[0]);
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(Integer.valueOf(values[0]));
            txtPercent.setText(values[0] + " % Loaded");
            if (progressBar.getProgress() == 100) {
                txtPercent.setText("Completed");
                btnStart.setEnabled(true);
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }

    private void initControls() {
        progressBar = findViewById(R.id.progressBar);
        txtPercent = findViewById(R.id.txtPercent);
        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);
        btnStart.setEnabled(true);
        btnStop.setEnabled(false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStart:
                MyIntentService.shouldContinue = true;
                Intent i = new Intent(this, MyIntentService.class);
                startService(i);
                btnStart.setEnabled(false);
                btnStop.setEnabled(true);
                break;
            case R.id.btnStop:
                MyIntentService.shouldContinue = false;
                btnStop.setEnabled(false);
                btnStart.setEnabled(true);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (receiver != null)
            unregisterReceiver(receiver);
    }
}
