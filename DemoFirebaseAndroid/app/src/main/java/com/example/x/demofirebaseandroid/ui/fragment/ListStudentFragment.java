package com.example.x.demofirebaseandroid.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.x.demofirebaseandroid.R;
import com.example.x.demofirebaseandroid.model.StudentModel;
import com.example.x.demofirebaseandroid.ui.adapter.StudentAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListStudentFragment extends Fragment {
    private StudentAdapter mAdapter;
    private ArrayList<StudentModel> mData;

    public ListStudentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_student, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        RecyclerView rvStudent = view.findViewById(R.id.rvStudent);
        mData = new ArrayList<>();
        mAdapter = new StudentAdapter(getActivity(), mData, database);
        rvStudent.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvStudent.setAdapter(mAdapter);
        database.child("Student").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                StudentModel st = dataSnapshot.getValue(StudentModel.class);
                st.setKey(dataSnapshot.getKey());
                mData.add(st);
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
