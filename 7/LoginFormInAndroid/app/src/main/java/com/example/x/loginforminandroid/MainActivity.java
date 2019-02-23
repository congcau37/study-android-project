package com.example.x.loginforminandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText txtEmail, txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControls();
    }

    private void initControls() {
        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
    }

    public void validateUserInformation(View view) {
        String email = txtEmail.getText().toString();
        String password = txtPassword.getText().toString();
        if (email.equals("admin@gmail.com") && password.equals("12345678"))
            Toast.makeText(this, "Welcome " + email, Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Invalid information, Please try again", Toast.LENGTH_SHORT).show();
    }
}
