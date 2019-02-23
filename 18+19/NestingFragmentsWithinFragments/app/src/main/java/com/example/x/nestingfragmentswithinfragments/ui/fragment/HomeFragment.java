package com.example.x.nestingfragmentswithinfragments.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.x.nestingfragmentswithinfragments.R;
import com.example.x.nestingfragmentswithinfragments.ui.activity.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements ChildFragment.Callback {
    private TextView txtResult;

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
        txtResult = view.findViewById(R.id.txtResult);
        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        ft.replace(R.id.flChildFragmentContainer, new ChildFragment());
        ft.commit();
    }

    @Override
    public void changeText() {
        txtResult.setText(R.string.txt_result);
    }
}
