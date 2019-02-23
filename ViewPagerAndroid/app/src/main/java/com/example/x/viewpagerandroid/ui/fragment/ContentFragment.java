package com.example.x.viewpagerandroid.ui.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.x.viewpagerandroid.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContentFragment extends Fragment {


    public ContentFragment() {
        // Required empty public constructor
    }

    public static ContentFragment newInstance(String content) {
        ContentFragment contentFragment = new ContentFragment();
        Bundle bd = new Bundle();
        bd.putString("content", content);
        contentFragment.setArguments(bd);
        return contentFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_content, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView txtResult = view.findViewById(R.id.txt);
        Bundle bd = getArguments();
        if (bd != null)
            txtResult.setText(bd.getString("content", ""));
    }
}
