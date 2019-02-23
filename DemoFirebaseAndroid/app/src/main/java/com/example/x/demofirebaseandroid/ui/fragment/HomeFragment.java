package com.example.x.demofirebaseandroid.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.x.demofirebaseandroid.R;
import com.example.x.demofirebaseandroid.config.common.Constants;
import com.example.x.demofirebaseandroid.model.StudentModel;
import com.example.x.demofirebaseandroid.ui.activity.MainActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private EditText txtInputName, txtInputAge;
    private DatabaseReference mDatabase;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        txtInputName = view.findViewById(R.id.txtInputName);
        txtInputAge = view.findViewById(R.id.txtInputAge);
        Button btnAdd = view.findViewById(R.id.btnAdd);
        Button btnShow = view.findViewById(R.id.btnShow);
        //handling click event for btnAdd
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = txtInputName.getText().toString();
                int age = Integer.parseInt(txtInputAge.getText().toString());
                StudentModel newStudent = new StudentModel(name, age);
                mDatabase.child("Student").push().setValue(newStudent);
                txtInputName.setText("");
                txtInputAge.setText("");
                Toast.makeText(getActivity(), name, Toast.LENGTH_SHORT).show();
            }
        });
        //handling click event for btnShow
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).nextFragment(
                        R.id.myLayout,
                        new ListStudentFragment(),
                        Constants.LIST_STUDENT_FRAGMENT_TAG
                );
            }
        });
        //
    }
}
