package com.example.x.horizontalscrollviewandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.widget.HorizontalScrollView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private HorizontalScrollView horizontalScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControls();
        initEvents();
    }

    private void initEvents() {
        horizontalScrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                Toast.makeText(MainActivity.this, "Scrolling", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initControls() {
        horizontalScrollView = findViewById(R.id.horizontalScrollView);
    }
}
