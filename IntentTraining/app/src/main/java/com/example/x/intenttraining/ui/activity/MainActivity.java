package com.example.x.intenttraining.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.x.intenttraining.R;
import com.example.x.intenttraining.model.StudentModel;

import java.util.ArrayList;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {
    private EditText mTxtName, mTxtAge;
    private ArrayList<StudentModel> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTxtName = findViewById(R.id.txtName);
        mTxtAge = findViewById(R.id.txtAge);
    }

    public void handleEvent(View view) {
        if (view.getId() == R.id.btnAdd) {
            String name = mTxtName.getText().toString();
            int age = Integer.parseInt(mTxtAge.getText().toString());
            mData.add(new StudentModel(name, age));
            mTxtName.setText("");
            mTxtAge.setText("");
            //add
        } else if (view.getId() == R.id.btnSend) {
            //send
            StudentModel svMax = mData.get(0);
            for (int i = 1; i < mData.size(); i++) {
                if (mData.get(i).getAge() > svMax.getAge()) {
                    svMax = mData.get(i);
                }
            }

            Intent i = new Intent(this, ResultActivity.class);
            Bundle bd = new Bundle();
            bd.putSerializable("svMax", svMax);
            i.putExtras(bd);
            startActivity(i);
        }
    }
}
