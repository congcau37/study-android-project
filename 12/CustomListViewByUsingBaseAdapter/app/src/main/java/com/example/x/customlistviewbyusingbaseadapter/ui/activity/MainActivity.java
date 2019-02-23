package com.example.x.customlistviewbyusingbaseadapter.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.example.x.customlistviewbyusingbaseadapter.R;
import com.example.x.customlistviewbyusingbaseadapter.model.StudentModel;
import com.example.x.customlistviewbyusingbaseadapter.ui.adapter.StudentAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lvStudents;
    private EditText txtName, txtAge;
    private ArrayList<StudentModel> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControls();
        initEvents();
    }

    private void initEvents() {
        lvStudents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
        txtName = findViewById(R.id.txtName);
        txtAge = findViewById(R.id.txtAge);
        lvStudents = findViewById(R.id.lvStudents);
        mData = new ArrayList<>();
        mData.addAll(initData());
        StudentAdapter adapter = new StudentAdapter(this, mData);
        lvStudents.setAdapter(adapter);
    }

    private ArrayList<StudentModel> initData() {
        ArrayList<StudentModel> data = new ArrayList<>();
        data.add(new StudentModel("Nguyen Van A", 28));
        data.add(new StudentModel("Nguyen Van B", 28));
        data.add(new StudentModel("Nguyen Van C", 28));
        data.add(new StudentModel("Nguyen Van D", 28));
        data.add(new StudentModel("Nguyen Van E", 28));
        data.add(new StudentModel("Nguyen Van F", 28));
        data.add(new StudentModel("Nguyen Van G", 28));
        data.add(new StudentModel("Nguyen Van H", 28));
        return data;
    }

    public void addNewStudent(View view) {
        mData.add(new StudentModel(txtName.getText().toString(), Integer.parseInt(txtAge.getText().toString())));
    }
}
