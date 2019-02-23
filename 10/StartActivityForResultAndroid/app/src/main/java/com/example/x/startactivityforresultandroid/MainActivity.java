package com.example.x.startactivityforresultandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText txtInputNumber;
    private TextView txtResult2;
    public static final int REQUEST_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControls();
    }

    private void initControls() {
        txtInputNumber = findViewById(R.id.txtInputNumber);
        txtResult2 = findViewById(R.id.txtResult2);
    }

    public void nextScreen(View view) {
        Intent i = new Intent(this, SecondActivity.class);
        Bundle bd = new Bundle();
        bd.putString("content", txtInputNumber.getText().toString());
        i.putExtras(bd);
        startActivityForResult(i, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            Bundle bd = data.getExtras();
            if (bd != null)
                txtResult2.setText(bd.getString("result", ""));
        }
    }
}
