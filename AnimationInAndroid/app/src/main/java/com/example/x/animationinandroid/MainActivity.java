package com.example.x.animationinandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

//github, svn, bitbucket
//custom view
//content provider
//rxjava
//rxAndroid
//sqlite, realm
//kotlin

public class MainActivity extends AppCompatActivity {
    //BƯỚC 1: CHUỘT PHẢI VÀO THƯ MỤC RES TẠO MỘT THƯ MỤC MỚI TÊN LÀ anim
    //BƯỚC 2: CHUỘT PHẢI VÀO THƯ MỤC ANIM CHỌN ANIMATION RESOURCE FILE
    //BƯỚC 3: ĐỔI SET THÀNH TÊN HIỆU ỨNG MÀ MÌNH ĐANG LÀM VIỆC
    //BƯỚC 4: KHỞI TẠO MỘT ĐỐI TƯỢNG CÓ KIỂU LÀ ANIMATION
    private TextView txt;
    private Animation alpha, scale, translate, rotate;
    private AnimationSet set;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.txt);
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
            case R.id.btnApla:
                txt.startAnimation(alpha);
                break;
            case R.id.btnScale:
                txt.startAnimation(scale);
                break;
            case R.id.btnTranslate:
                txt.startAnimation(translate);
                break;
            case R.id.btnRotate:
                txt.startAnimation(rotate);
                break;
            case R.id.btnMix:
                txt.startAnimation(set);
                break;
        }
    }
}
