package com.example.x.buttoninandroid;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControls();
    }

    private void initControls() {
        Button btn = findViewById(R.id.btn);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/lobsterregular.ttf");
        btn.setTypeface(typeface);
    }
}
