package com.example.x.edittextandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControls();
    }

    private void initControls() {
        TextView txtInputName = findViewById(R.id.txtInputName);
        Toast.makeText(this, txtInputName.getText().toString(), Toast.LENGTH_SHORT).show();
    }
}
