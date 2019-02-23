package com.example.x.firebaseandroid.ui.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.x.firebaseandroid.R;
import com.example.x.firebaseandroid.model.StudentModel;
import com.example.x.firebaseandroid.ui.adapter.StudentAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListStudentActivity extends AppCompatActivity {
    private ArrayList<StudentModel> mData;
    private StudentAdapter mAdapter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_student);
        initControls();
    }

    private void initControls() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Waiting");
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();
        RecyclerView rvStudents = findViewById(R.id.rvStudents);
        mData = new ArrayList<>();
        mAdapter = new StudentAdapter(this, mData);
        rvStudents.setLayoutManager(new LinearLayoutManager(this));
        rvStudents.setAdapter(mAdapter);
        final DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        database.child("Student").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (progressDialog.isShowing())
                    progressDialog.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        database.child("Student").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                StudentModel newStudent = dataSnapshot.getValue(StudentModel.class);
                newStudent.setKey(dataSnapshot.getKey());
                mData.add(newStudent);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
