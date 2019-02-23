package com.example.x.displayingimageswiththeglidelibrary;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControls();
    }

    private void initControls() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Waiting");
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();
        ImageView img = findViewById(R.id.imgLandscape);
        Glide.with(this)
                .load("https://i.pinimg.com/736x/21/0a/d2/210ad23f1b3d608c4f8a1001c9a58378--asian-landscape-green-landscape.jpg")
                .override(200, 200)
                .centerCrop()
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        if (progressDialog.isShowing())
                            progressDialog.dismiss();
                        return false; // important to return false so the error placeholder can be placed
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        if (progressDialog.isShowing())
                            progressDialog.dismiss();
                        return false;
                    }
                })
                .bitmapTransform(new CropCircleTransformation(this))
                .into(img);
    }
}
