package com.example.x.sqlitebycoding.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.x.sqlitebycoding.R;
import com.example.x.sqlitebycoding.data.StudentDao;
import com.example.x.sqlitebycoding.model.StudentModel;

public class AddNewStudentActivity extends AppCompatActivity {
    private EditText txtInputName, txtInputAge;
    private StudentDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_student);
        initControls();
    }

    private void initControls() {
        txtInputAge = findViewById(R.id.txtInputAge);
        txtInputName = findViewById(R.id.txtInputName);
        dao = new StudentDao(this);
        dao.open();
    }

    public void addNewStudent(View view) {
        String name = txtInputName.getText().toString();
        if (dao.addNewStudent(new StudentModel(name, Integer.parseInt(txtInputAge.getText().toString()))) != -1)
            Toast.makeText(this, "Add " + name + " successfully", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Add " + name + "Fail", Toast.LENGTH_SHORT).show();
        txtInputName.setText("");
        txtInputAge.setText("");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dao.close();
        Log.d("SQLiteByCoding", "Database Closed");
    }
}
