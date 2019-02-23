package com.example.x.customgridviewandroidbyusingbaseadapter.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import com.example.x.customgridviewandroidbyusingbaseadapter.R;
import com.example.x.customgridviewandroidbyusingbaseadapter.model.StudentModel;
import com.example.x.customgridviewandroidbyusingbaseadapter.ui.adapter.StudentAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText txtInputName, txtInputAge;
    private GridView gvStudents;
    private StudentAdapter mAdapter;
    private ArrayList<StudentModel> mData;

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
                Intent i = new Intent(MainActivity.this, DetailActivity.class);
                Bundle bd = new Bundle();
                bd.putString("name", mData.get(position).getName());
                bd.putInt("age", mData.get(position).getAge());
                i.putExtras(bd);
                startActivity(i);
            }
        });
    }

    private void initControls() {
        gvStudents = findViewById(R.id.gvStudents);
        txtInputName = findViewById(R.id.txtInputName);
        txtInputAge = findViewById(R.id.txtInputAge);
        mData = new ArrayList<>();
        mData.addAll(initData());
        mAdapter = new StudentAdapter(this, mData);
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
        mData.add(new StudentModel(txtInputName.getText().toString(), Integer.parseInt(txtInputAge.getText().toString())));
        mAdapter.notifyDataSetChanged();
    }
}
