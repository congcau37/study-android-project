package com.example.x.textviewandroid;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControls();
    }

    private void initControls() {
        TextView txt = findViewById(R.id.txt);
        txt.setText(R.string.txt_new_content);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/lobsterregular.ttf");
        txt.setTypeface(typeface);
    }
}
