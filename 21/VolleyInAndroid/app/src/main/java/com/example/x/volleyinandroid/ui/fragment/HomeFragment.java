package com.example.x.volleyinandroid.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.x.volleyinandroid.R;
import com.example.x.volleyinandroid.ui.activity.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {
    private Button btnAdd, btnShow;
    private View view1 = null;
    private boolean flag = false;
    private AddNewStudentFragment addNewStudentFragment;
    private ListStudentFragment listStudentFragment;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (view1 == null) {
            view1 = inflater.inflate(R.layout.fragment_home, container, false);
            flag = false;
        } else {
            flag = true;
        }
        return view1;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initControls(view);
        initEvents();
    }

    private void initEvents() {
        btnAdd.setOnClickListener(this);
        btnShow.setOnClickListener(this);
    }

    private void initControls(View view) {
        btnAdd = view.findViewById(R.id.btnAdd);
        btnShow = view.findViewById(R.id.btnShow);
        if (!flag) {
            addNewStudentFragment = new AddNewStudentFragment();
            listStudentFragment = new ListStudentFragment();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAdd:
                ((MainActivity) getActivity()).nextFragment(R.id.myLayout, addNewStudentFragment);
                break;
            case R.id.btnShow:
                ((MainActivity) getActivity()).nextFragment(R.id.myLayout, listStudentFragment);
                break;
        }
    }
}
