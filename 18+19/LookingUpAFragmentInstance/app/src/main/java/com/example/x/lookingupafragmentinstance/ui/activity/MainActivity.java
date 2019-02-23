package com.example.x.lookingupafragmentinstance.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.x.lookingupafragmentinstance.R;
import com.example.x.lookingupafragmentinstance.ui.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        initControls();
//        nextFragment(R.id.myLayout, new HomeFragment());
        nextFragment(R.id.myLayout, new HomeFragment(), "HOME_FRAGMENT");
        initControls();
        // returns first Fragment item within the pager
//        adapterViewPager.getRegisteredFragment(0);
    }

    private void initControls() {
//        HomeFragment homeFragment = (HomeFragment) getSupportFragmentManager().findFragmentById(R.id.myLayout);
        HomeFragment homeFragment = (HomeFragment) getSupportFragmentManager().findFragmentByTag("HOME_FRAGMENT");
    }
//
//    private void initControls() {
//        HomeFragment homeFragment = (HomeFragment) getSupportFragmentManager().findFragmentById(R.id.homeFragment);
//    }

    public void nextFragment(int id, Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(id, fragment);
        ft.commit();
    }

    public void nextFragment(int id, Fragment fragment, String tag) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(id, fragment, tag);
        ft.commit();
    }
}
