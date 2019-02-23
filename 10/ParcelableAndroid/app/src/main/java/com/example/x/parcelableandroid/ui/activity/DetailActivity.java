package com.example.x.parcelableandroid.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.x.parcelableandroid.R;
import com.example.x.parcelableandroid.model.StudentModel;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initControls();
    }

    private void initControls() {
        TextView txtName = findViewById(R.id.txtName);
        TextView txtAge = findViewById(R.id.txtAge);
        Bundle bd = getIntent().getExtras();
        if (bd != null) {
            ArrayList<StudentModel> data = bd.getParcelableArrayList("data");
            StudentModel result = data.get(0);
            for (int i = 1; i < data.size(); i++) {
                if (data.get(i).getAge() > result.getAge()) {
                    result = data.get(i);
                }
            }
            txtName.setText(result.getName());
            txtAge.setText(String.valueOf(result.getAge()));
        }
    }
}
