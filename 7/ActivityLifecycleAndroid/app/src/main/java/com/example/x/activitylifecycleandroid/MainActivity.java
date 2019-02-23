package com.example.x.activitylifecycleandroid;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int count = 0;
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("ActivityLifeCycle", "onCreate started");
        txt = findViewById(R.id.txt);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ActivityLifeCycle", "onStart started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ActivityLifeCycle", "onResume started");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("ActivityLifeCycle", "onRestart started");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count", count);
        Log.d("ActivityLifeCycle", count + "was saved");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            count = savedInstanceState.getInt("count");
            Log.d("ActivityLifeCycle", count + " was restored");
            count++;
            txt.setText(String.valueOf(count));
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ActivityLifeCycle", "onPause started");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ActivityLifeCycle", "onStop started");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ActivityLifeCycle", "onDestroy started");
    }
}
