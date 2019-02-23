package com.example.x.managingfragmentbackstack.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.x.managingfragmentbackstack.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {


    public DetailFragment() {
        // Required empty public constructor
    }

    public static DetailFragment newInstance(String content) {
        DetailFragment detailFragment = new DetailFragment();
        Bundle bd = new Bundle();
        bd.putString("content", content);
        detailFragment.setArguments(bd);
        return detailFragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView txtResult = view.findViewById(R.id.txtResult);
        Bundle bd = getArguments();
        if (bd != null)
            txtResult.setText(bd.getString("content", ""));
    }
}
