package com.example.x.communicatingwithfragmentsbyusingmethods.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.x.communicatingwithfragmentsbyusingmethods.R;
import com.example.x.communicatingwithfragmentsbyusingmethods.ui.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControls();
    }

    private void initControls() {
        HomeFragment homeFragment = (HomeFragment) getSupportFragmentManager().findFragmentById(R.id.homeFragment);
        homeFragment.changeText("Hello Android");
    }
}
