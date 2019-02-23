package com.example.x.viewflipperandroid.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ViewFlipper;

import com.example.x.viewflipperandroid.R;
import com.example.x.viewflipperandroid.model.ImageModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        initControls();
    }

    private void initControls() {
        ViewFlipper viewFlipper = findViewById(R.id.viewFlipper);
        ImageModel arrImage[] = new ImageModel[3];
        arrImage[0] = new ImageModel(R.drawable.index1);
        arrImage[1] = new ImageModel(R.drawable.index2);
        arrImage[2] = new ImageModel(R.drawable.index3);
        for (int i = 0; i < arrImage.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(arrImage[i].getIdImage());
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            viewFlipper.addView(imageView);
        }
        viewFlipper.setInAnimation(this, R.anim.fade_in);
        viewFlipper.setOutAnimation(this, R.anim.fade_out);
        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(2000);
    }
}
