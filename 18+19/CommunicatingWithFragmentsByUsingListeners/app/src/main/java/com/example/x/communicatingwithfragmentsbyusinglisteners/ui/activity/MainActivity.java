package com.example.x.communicatingwithfragmentsbyusinglisteners.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.x.communicatingwithfragmentsbyusinglisteners.R;
import com.example.x.communicatingwithfragmentsbyusinglisteners.ui.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity implements HomeFragment.Callback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nextFragment(R.id.myLayout, new HomeFragment());
    }

    public void nextFragment(int id, Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(id, fragment);
        ft.commit();
    }

    @Override
    public void handle() {
        HomeFragment homeFragment = (HomeFragment) getSupportFragmentManager().findFragmentById(R.id.myLayout);
        homeFragment.changeText();
    }
}
