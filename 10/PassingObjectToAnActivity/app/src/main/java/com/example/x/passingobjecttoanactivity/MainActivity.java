package com.example.x.passingobjecttoanactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText txtInputName, txtInputAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControls();
    }

    private void initControls() {
        txtInputName = findViewById(R.id.txtInputName);
        txtInputAge = findViewById(R.id.txtInputAge);

    }

    public void nextScreen(View view) {
        StudentModel newStudent = new StudentModel(
                txtInputName.getText().toString(),
                Integer.parseInt(txtInputAge.getText().toString())
        );
        Intent i = new Intent(this, DetailActivity.class);
        Bundle bd = new Bundle();
        bd.putSerializable("student", newStudent);
        i.putExtras(bd);
    }
}
