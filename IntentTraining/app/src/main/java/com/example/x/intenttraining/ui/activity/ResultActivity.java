package com.example.x.intenttraining.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.x.intenttraining.R;
import com.example.x.intenttraining.model.StudentModel;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView mTxtNameContent = findViewById(R.id.txtNameContent);
        TextView mTxtAgeContent = findViewById(R.id.txtAgeContent);
        Bundle bd = getIntent().getExtras();
        if (bd != null) {
            StudentModel studentModel = (StudentModel) bd.getSerializable("svMax");
            mTxtNameContent.setText(studentModel.getName());
            mTxtAgeContent.setText(String.valueOf(studentModel.getAge()));
        }
    }
}
