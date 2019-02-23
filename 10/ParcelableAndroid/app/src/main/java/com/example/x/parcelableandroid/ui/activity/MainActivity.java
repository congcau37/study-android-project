package com.example.x.parcelableandroid.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.x.parcelableandroid.R;
import com.example.x.parcelableandroid.model.StudentModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText txtInputName, txtInputAge;
    private ArrayList<StudentModel> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControls();
    }

    private void initControls() {
        txtInputName = findViewById(R.id.txtInputName);
        txtInputAge = findViewById(R.id.txtInputAge);
        mData = new ArrayList<>();
    }

    public void handle(View view) {
        switch (view.getId()) {
            case R.id.btnAdd:
                String name = txtInputName.getText().toString();
                int age = Integer.parseInt(txtInputAge.getText().toString());
                StudentModel newStudent = new StudentModel(name, age);
                mData.add(newStudent);
                txtInputName.setText("");
                txtInputAge.setText("");
                Toast.makeText(this, "Add " + name + " successfully", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnShow:
                Intent i = new Intent(this, DetailActivity.class);
                Bundle bd = new Bundle();
                bd.putParcelableArrayList("data", mData);
                i.putExtras(bd);
                startActivity(i);
                break;
        }
    }
}
