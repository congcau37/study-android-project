package com.example.x.customgridviewandroidbyusingarrayadapter.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import com.example.x.customgridviewandroidbyusingarrayadapter.R;
import com.example.x.customgridviewandroidbyusingarrayadapter.model.StudentModel;
import com.example.x.customgridviewandroidbyusingarrayadapter.ui.adapter.StudentAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText txtInputName, txtInputAge;
    private GridView gvStudents;
    private StudentAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControls();
        initEvents();
    }

    private void initEvents() {
        gvStudents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, mAdapter.getItem(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initControls() {
        gvStudents = findViewById(R.id.gvStudents);
        txtInputName = findViewById(R.id.txtInputName);
        txtInputAge = findViewById(R.id.txtInputAge);
        mAdapter = new StudentAdapter(this, initData());
        gvStudents.setAdapter(mAdapter);
    }

    private ArrayList<StudentModel> initData() {
        ArrayList<StudentModel> data = new ArrayList<>();
        data.add(new StudentModel("Nguyen Van A", 28));
        data.add(new StudentModel("Nguyen Van B", 28));
        data.add(new StudentModel("Nguyen Van C", 28));
        data.add(new StudentModel("Nguyen Van D", 28));
        data.add(new StudentModel("Nguyen Van E", 28));
        data.add(new StudentModel("Nguyen Van G", 28));
        data.add(new StudentModel("Nguyen Van H", 28));
        return data;
    }

    public void addNewStudent(View view) {
        mAdapter.add(new StudentModel(txtInputName.getText().toString(), Integer.parseInt(txtInputAge.getText().toString())));
    }
}
