package com.example.x.customgridviewandroidbyusingbaseadapter.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.x.customgridviewandroidbyusingbaseadapter.R;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initControls();
    }

    private void initControls() {
        TextView txtNameContent = findViewById(R.id.txtNameContent);
        TextView txtAgeContent = findViewById(R.id.txtAgeContent);
        Bundle bd = getIntent().getExtras();
        if (bd != null) {
            txtNameContent.setText(bd.getString("name"));
            txtAgeContent.setText(String.valueOf(bd.getInt("age")));
        }
    }
}
