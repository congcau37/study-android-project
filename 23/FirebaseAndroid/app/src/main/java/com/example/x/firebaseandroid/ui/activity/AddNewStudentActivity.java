package com.example.x.firebaseandroid.ui.activity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.x.firebaseandroid.R;
import com.example.x.firebaseandroid.model.StudentModel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddNewStudentActivity extends AppCompatActivity {
    private EditText txtInputName, txtInputAge;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_student);
        initControls();
    }

    private void initControls() {
        txtInputName = findViewById(R.id.txtInputName);
        txtInputAge = findViewById(R.id.txtInputAge);
    }

    public void addNewStudent(View view) {
        name = txtInputName.getText().toString();
        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        database.child("Student").push().setValue(
                new StudentModel(
                        txtInputName.getText().toString(),
                        Integer.parseInt(txtInputAge.getText().toString())
                )
        ).addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(AddNewStudentActivity.this, "Add " + name + " successfully", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(this, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(AddNewStudentActivity.this, "Add " + name + " fail", Toast.LENGTH_SHORT).show();
            }
        });
        txtInputName.setText("");
        txtInputAge.setText("");
    }
}
