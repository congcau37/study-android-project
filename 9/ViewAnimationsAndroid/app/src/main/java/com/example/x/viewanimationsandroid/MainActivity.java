package com.example.x.viewanimationsandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {
    private View myView;
    private Animation alpha, scale, translate, rotate;
    private AnimationSet set;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControls();
    }

    private void initControls() {
        myView = findViewById(R.id.myView);
        alpha = AnimationUtils.loadAnimation(this, R.anim.alpha);
        scale = AnimationUtils.loadAnimation(this, R.anim.scale);
        translate = AnimationUtils.loadAnimation(this, R.anim.translate);
        rotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
        set = new AnimationSet(true);
        set.addAnimation(alpha);
        set.addAnimation(scale);
        set.addAnimation(translate);
        set.addAnimation(rotate);
    }

    public void initAnimation(View view) {
        switch (view.getId()) {
            case R.id.btnAlpha:
                myView.startAnimation(alpha);
                break;
            case R.id.btnScale:
                myView.startAnimation(scale);
                break;
            case R.id.btnTranslate:
                myView.startAnimation(translate);
                break;
            case R.id.btnRotate:
                myView.startAnimation(rotate);
                break;
            case R.id.btnMix:
                myView.startAnimation(set);
                break;
        }
    }
}
