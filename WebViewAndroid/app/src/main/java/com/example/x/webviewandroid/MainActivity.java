package com.example.x.webviewandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText txtInputUrl;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControls();
    }

    private void initControls() {
        ProgressBar progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
        txtInputUrl = findViewById(R.id.txtInputUrl);
        webView = findViewById(R.id.webView);
        webView.setWebViewClient(new MyWebViewClient(txtInputUrl, progressBar));
    }

    public void openWeb(View view) {
        switch (view.getId()) {
            case R.id.btnStaticContent:
                showStaticContent();
                break;
            case R.id.btnGo:
                goUrl();
                break;
        }
    }

    private void showStaticContent() {
        String staticContent = "<h2>Select web page</h2>"
                + "<ul><li><a href='http://eclipse.org'>Eclipse</a></li>"
                + "<li><a href='http://google.com'>Google</a></li></ul>";
        webView.loadData(staticContent, "text/html", "UTF-8");
    }

    private void goUrl() {
        String url = txtInputUrl.getText().toString();
        if (url.equals("")) {
            Toast.makeText(this, "Please input url", Toast.LENGTH_SHORT).show();
            return;
        }
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.loadUrl(url);
    }
}
