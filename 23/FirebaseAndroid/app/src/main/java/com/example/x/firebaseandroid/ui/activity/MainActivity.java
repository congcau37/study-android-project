package com.example.x.firebaseandroid.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.x.firebaseandroid.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void handle(View view) {
        switch (view.getId()) {
            case R.id.btnAdd:
                Intent i = new Intent(this, AddNewStudentActivity.class);
                startActivity(i);
                break;
            case R.id.btnshow:
                Intent i1 = new Intent(this, ListStudentActivity.class);
                startActivity(i1);
                break;
        }
    }
}
