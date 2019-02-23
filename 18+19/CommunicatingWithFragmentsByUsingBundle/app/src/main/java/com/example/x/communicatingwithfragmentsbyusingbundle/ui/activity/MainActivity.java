package com.example.x.communicatingwithfragmentsbyusingbundle.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.x.communicatingwithfragmentsbyusingbundle.R;
import com.example.x.communicatingwithfragmentsbyusingbundle.ui.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nextFragment(R.id.myLayout, HomeFragment.newInstance("Hello Android"));
    }

    public void nextFragment(int id, Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(id, fragment);
        ft.commit();
    }
}
