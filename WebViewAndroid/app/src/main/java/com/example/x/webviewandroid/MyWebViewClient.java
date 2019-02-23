package com.example.x.webviewandroid;

/* Created by X on 12/3/2017.
* */

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MyWebViewClient extends WebViewClient {
    private EditText txtInputUrl;
    private ProgressBar progressBar;

    public MyWebViewClient(EditText txtInputUrl, ProgressBar progressBar) {
        this.txtInputUrl = txtInputUrl;
        this.progressBar = progressBar;
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onLoadResource(WebView view, String url) {
        super.onLoadResource(view, url);
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        txtInputUrl.setText(url);
        return super.shouldOverrideUrlLoading(view, url);
    }
}
