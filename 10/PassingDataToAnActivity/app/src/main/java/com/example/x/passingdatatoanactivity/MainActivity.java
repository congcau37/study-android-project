package com.example.x.passingdatatoanactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText txtInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControls();
    }

    private void initControls() {
        txtInput = findViewById(R.id.txtInput);
    }

    public void nextScreen(View view) {
        Intent i = new Intent(this, DetailActivity.class);
        Bundle bd = new Bundle();
        bd.putString("content", txtInput.getText().toString());
        i.putExtras(bd);
        startActivity(i);
    }
}
