package com.example.x.buttonclickevent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn2, btn3, btn4, btn5;
    private View.OnClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControls();
        initEvents();
    }

    private void initEvents() {
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Button2 was clicked", Toast.LENGTH_SHORT).show();
            }
        });
        btn3.setOnClickListener(this);
        listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Button4 was clicked", Toast.LENGTH_SHORT).show();
            }
        };
        btn4.setOnClickListener(listener);
        btn5.setOnClickListener(new HandleButton5());
    }

    private void initControls() {
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
    }

    public void handleButton1(View view) {
        Toast.makeText(this, "Button1 was clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Button3 was clicked", Toast.LENGTH_SHORT).show();
    }

    private class HandleButton5 implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, "Button5 was clicked", Toast.LENGTH_SHORT).show();
        }
    }
}
