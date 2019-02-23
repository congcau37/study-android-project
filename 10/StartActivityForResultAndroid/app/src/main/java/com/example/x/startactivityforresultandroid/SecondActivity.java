package com.example.x.startactivityforresultandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private String result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initControls();
    }

    private void initControls() {
        TextView txtResult = findViewById(R.id.txtResult);
        Bundle bd = getIntent().getExtras();
        if (bd != null) {
            int number = Integer.parseInt(bd.getString("content", ""));
            txtResult.setText(String.valueOf(number));
            if (number % 2 == 0)
                result = "even";
            else
                result = "odd";
        }
    }

    public void returnScreen(View view) {
        Intent i = new Intent();
        Bundle bd = new Bundle();
        bd.putString("result", result);
        i.putExtras(bd);
        setResult(RESULT_OK, i);
        finish();
    }
}
