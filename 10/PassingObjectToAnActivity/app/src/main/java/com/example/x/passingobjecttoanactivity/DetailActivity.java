package com.example.x.passingobjecttoanactivity;

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
        TextView txtNameResult = findViewById(R.id.txtNameResult);
        TextView txtAgeResult = findViewById(R.id.txtAgeResult);
        Bundle bd = getIntent().getExtras();
        if (bd != null) {
            StudentModel newStudent = (StudentModel) bd.getSerializable("student");
            txtNameResult.setText(newStudent.getName());
            txtAgeResult.setText(String.valueOf(newStudent.getAge()));
        }
    }
}
