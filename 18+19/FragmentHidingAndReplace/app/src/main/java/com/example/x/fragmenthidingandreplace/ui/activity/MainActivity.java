package com.example.x.fragmenthidingandreplace.ui.activity;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.x.fragmenthidingandreplace.R;
import com.example.x.fragmenthidingandreplace.ui.fragment.AFragment;
import com.example.x.fragmenthidingandreplace.ui.fragment.BFragment;
import com.example.x.fragmenthidingandreplace.ui.fragment.CFragment;

public class MainActivity extends AppCompatActivity {
    private AFragment fragmentA;
    private BFragment fragmentB;
    private CFragment fragmentC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            fragmentA = new AFragment();
            fragmentB = new BFragment();
            fragmentC = new CFragment();
        }
    }

    public void displayFragment(View view) {
        switch (view.getId()) {
            case R.id.btnShowFragmentA:
                showFragmentA();
                break;
            case R.id.btnShowFragmentB:
                showFragmentB();
                break;
            case R.id.btnShowFragmentC:
                showFragmentC();
                break;
        }
    }

    private void showFragmentC() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (fragmentC.isAdded())
            ft.show(fragmentC);
        else
            ft.add(R.id.myLayout, fragmentC);
        if (fragmentB.isAdded())
            ft.hide(fragmentB);
        if (fragmentA.isAdded())
            ft.hide(fragmentA);
        ft.commit();
    }

    private void showFragmentB() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (fragmentB.isAdded())
            ft.show(fragmentB);
        else
            ft.add(R.id.myLayout, fragmentB);
        if (fragmentA.isAdded())
            ft.hide(fragmentA);
        if (fragmentC.isAdded())
            ft.hide(fragmentC);
        ft.commit();
    }

    private void showFragmentA() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (fragmentA.isAdded())
            ft.show(fragmentA);
        else
            ft.add(R.id.myLayout, fragmentA);
        if (fragmentB.isAdded())
            ft.hide(fragmentB);
        if (fragmentC.isAdded())
            ft.hide(fragmentC);
        ft.commit();
    }
}
