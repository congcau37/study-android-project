package com.example.x.passingdatatoanactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initControls();
    }

    private void initControls() {
        TextView txtResult = findViewById(R.id.txtResult);
        Bundle bd = getIntent().getExtras();
        if (bd != null)
            txtResult.setText(bd.getString("content"));
    }
}
