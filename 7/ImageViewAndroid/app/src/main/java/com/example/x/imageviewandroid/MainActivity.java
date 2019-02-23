package com.example.x.imageviewandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControls();
    }

    private void initControls() {
        ImageView imgBackground = findViewById(R.id.imgBackground);
        imgBackground.setImageResource(R.drawable.img_background);
    }
}
