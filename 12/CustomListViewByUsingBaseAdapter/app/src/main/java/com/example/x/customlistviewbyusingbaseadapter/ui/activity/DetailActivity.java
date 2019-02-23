package com.example.x.customlistviewbyusingbaseadapter.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.x.customlistviewbyusingbaseadapter.R;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initControls();
    }

    private void initControls() {
        TextView txtNameResult = findViewById(R.id.txtNameResult);
        TextView txtAgeResult = findViewById(R.id.txtAgeResult);
        Bundle bd = getIntent().getExtras();
        if (bd != null) {
            String name = bd.getString("name");
            int age = bd.getInt("age");
            txtNameResult.setText(name);
            txtAgeResult.setText(String.valueOf(age));
        }
    }
}
