package com.example.x.usingtherecyclerview.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.example.x.usingtherecyclerview.R;
import com.example.x.usingtherecyclerview.model.StudentModel;
import com.example.x.usingtherecyclerview.ui.adapter.StudentAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText txtInputName, txtInputAge;
    private ArrayList<StudentModel> mData;
    private StudentAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControls();
    }

    private void initControls() {
        txtInputName = findViewById(R.id.txtInputName);
        txtInputAge = findViewById(R.id.txtInputAge);
        RecyclerView rvStudents = findViewById(R.id.rvStudents);
        mData = new ArrayList<>();
        mData.addAll(initData());
        mAdapter = new StudentAdapter(this, mData);
//        rvStudents.setLayoutManager(new GridLayoutManager(this, 2));
        rvStudents.setLayoutManager(new LinearLayoutManager(this));
//        rvStudents.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvStudents.setAdapter(mAdapter);
    }

    private ArrayList<StudentModel> initData() {
        ArrayList<StudentModel> data = new ArrayList<>();
        data.add(new StudentModel("Nguyen Van A", 29));
        data.add(new StudentModel("Nguyen Van B", 29));
        data.add(new StudentModel("Nguyen Van C", 29));
        data.add(new StudentModel("Nguyen Van D", 29));
        data.add(new StudentModel("Nguyen Van E", 29));
        data.add(new StudentModel("Nguyen Van F", 29));
        data.add(new StudentModel("Nguyen Van G", 29));
        return data;
    }

    public void addNewStudent(View view) {
        mData.add(new StudentModel(txtInputName.getText().toString(), Integer.parseInt(txtInputAge.getText().toString())));
        mAdapter.notifyItemInserted(mData.size() - 1);
        txtInputName.setText("");
        txtInputAge.setText("");
    }
}
