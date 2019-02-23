package com.example.x.demofirebaseandroid.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.x.demofirebaseandroid.R;
import com.example.x.demofirebaseandroid.config.common.Constants;
import com.example.x.demofirebaseandroid.ui.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity {
    private HomeFragment homeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null)
            homeFragment = (HomeFragment) getSupportFragmentManager().findFragmentByTag(Constants.HOME_FRAGMENT_TAG);
        else if (homeFragment == null)
            homeFragment = new HomeFragment();
        if (!homeFragment.isInLayout())
            nextFragment(R.id.myLayout, homeFragment, Constants.HOME_FRAGMENT_TAG);
    }

    public void nextFragment(int id, Fragment fragment, String tag) {
        String name = fragment.getClass().getName();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(id, fragment, tag);
        ft.addToBackStack(name);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }
}
