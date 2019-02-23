package com.example.x.toastandroid;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showToast(View view) {
        switch (view.getId()) {
            case R.id.btnShowNormalToast:
                showNormalToast("Hello Android");
                break;
            case R.id.btnShowCustomToast:
                showCustomToast(this, "Hello Android", Toast.LENGTH_LONG);
                break;
        }
    }

    private void showNormalToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    private void showCustomToast(Context context, String content, int duration) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_toast, null);
        TextView txt = view.findViewById(R.id.txt);
        txt.setText(content);
        Toast t = new Toast(context);
        t.setGravity(Gravity.CENTER, 0, 0);
        t.setView(view);
        t.setDuration(duration);
        t.show();
    }
}
