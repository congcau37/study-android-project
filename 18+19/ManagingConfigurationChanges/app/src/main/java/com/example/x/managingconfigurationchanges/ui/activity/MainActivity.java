package com.example.x.managingconfigurationchanges.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.x.managingconfigurationchanges.R;
import com.example.x.managingconfigurationchanges.ui.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity {
    private HomeFragment homeFragment;
    private final String SIMPLE_FRAGMENT_TAG = "myfragmenttag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) { // saved instance state, fragment may exist
            // look up the instance that already exists by tag
            homeFragment = (HomeFragment)
                    getSupportFragmentManager().findFragmentByTag(SIMPLE_FRAGMENT_TAG);
        } else if (homeFragment == null) {
            // only create fragment if they haven't been instantiated already
            homeFragment = new HomeFragment();
        }
        if (!homeFragment.isInLayout()) {
            nextFragment(R.id.myLayout, homeFragment);
        }
    }

    public void nextFragment(int id, Fragment fragment) {
        String name = fragment.getClass().getName();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(id, fragment);
        ft.addToBackStack(name);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }
}
