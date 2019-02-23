package com.example.x.implicitintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void handle(View view) {
        switch (view.getId()) {
            case R.id.btnCall:
                String phone = "0123456789";
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(intent);
                break;
            case R.id.btnSendSms:
                String number = "0123456789";  // The number on which you want to send SMS
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", number, null)));
                break;
            case R.id.btnSendEmail:
                Intent i2 = new Intent(Intent.ACTION_SENDTO);
                i2.setType("text/plain");
                i2.putExtra(Intent.EXTRA_EMAIL, "admin@gmail.com");
                i2.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                i2.putExtra(Intent.EXTRA_TEXT, "I'm email body.");

                startActivity(Intent.createChooser(i2, "Send Email"));
                break;
        }
    }
}
