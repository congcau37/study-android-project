package com.example.x.sqlitebycoding.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.x.sqlitebycoding.R;
import com.example.x.sqlitebycoding.data.StudentDao;
import com.example.x.sqlitebycoding.model.StudentModel;
import com.example.x.sqlitebycoding.ui.adapter.StudentAdapter;

import java.util.ArrayList;

public class ListStudentActivity extends AppCompatActivity {
    private StudentDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_student);
        initControls();
    }

    private void initControls() {
        RecyclerView rvStudents = findViewById(R.id.rvStudents);
        dao = new StudentDao(this);
        dao.open();
        ArrayList<StudentModel> data = new ArrayList<>();
        data.addAll(dao.getStudentList());
        StudentAdapter adapter = new StudentAdapter(this, data, dao);
        rvStudents.setLayoutManager(new LinearLayoutManager(this));
        rvStudents.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dao.close();
    }
}
