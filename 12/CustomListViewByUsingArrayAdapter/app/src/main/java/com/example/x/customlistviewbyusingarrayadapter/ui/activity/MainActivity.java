package com.example.x.customlistviewbyusingarrayadapter.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.x.customlistviewbyusingarrayadapter.R;
import com.example.x.customlistviewbyusingarrayadapter.model.StudentModel;
import com.example.x.customlistviewbyusingarrayadapter.ui.adapter.StudentAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lvStudents;
    private EditText txtName, txtAge;
    private StudentAdapter mAdapter;

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
                Toast.makeText(MainActivity.this, mAdapter.getItem(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initControls() {
        txtName = findViewById(R.id.txtName);
        txtAge = findViewById(R.id.txtAge);
        lvStudents = findViewById(R.id.lvStudents);
        mAdapter = new StudentAdapter(this, initData());
        lvStudents.setAdapter(mAdapter);
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
        mAdapter.add(new StudentModel(txtName.getText().toString(), Integer.parseInt(txtAge.getText().toString())));
    }
}
