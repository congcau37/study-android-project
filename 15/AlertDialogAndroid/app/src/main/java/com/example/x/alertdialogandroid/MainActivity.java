package com.example.x.alertdialogandroid;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText txtInputEmail, txtInputPassword;
    private Button btnLogin;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showAlertDialog(View view) {
        switch (view.getId()) {
            case R.id.btnShowNormalAlertDialog:
                showNormalAlertDialog(this);
                break;
            case R.id.btnShowAlertDialogList:
                showAlertDialogList(this);
                break;
            case R.id.btnShowCustomAlertDialog:
                showCustomAlertDialog(this);
                break;
        }
    }

    private void showCustomAlertDialog(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_alert_dialog, null);
        initControls(view);
        initEvents();
        dialog = new Dialog(context);
        dialog.setContentView(view);
        dialog.show();
    }

    private void initEvents() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtInputEmail.getText().toString().equals("admin@gmail.com") && txtInputPassword.getText().toString().equals("12345678"))
                    Toast.makeText(MainActivity.this, "Welcome " + txtInputEmail.getText().toString(), Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Invalid value, please try again", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
    }

    private void initControls(View view) {
        txtInputEmail = view.findViewById(R.id.txtInputEmail);
        txtInputPassword = view.findViewById(R.id.txtInputPassword);
        btnLogin = view.findViewById(R.id.btnLogin);
    }

    private void showAlertDialogList(final Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        final String[] courses = new String[]{"PHP", "Android", "React Native"};
        builder.setTitle("Programming Courses");
        builder.setItems(courses, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, courses[which], Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();
    }

    private void showNormalAlertDialog(final Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Message");
        builder.setMessage("Hello, My name is Alert Dialog");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "Nice to meet you", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "Nice to meet you", Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();
    }
}
