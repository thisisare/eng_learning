package com.example.dula;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        Toolbar toolbar3 = findViewById(R.id.toolbarwebview);
        toolbar3.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);

        Intent intent1 = getIntent();
        String toolbar_title = intent1.getStringExtra("toolbar_title");

        setSupportActionBar(toolbar3);
        getSupportActionBar().setTitle(toolbar_title);


        toolbar3.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebViewActivity.this.onBackPressed();
            }
        });


        //WebView webView = findViewById(R.id.webview1);
        //webView.getSettings().setJavaScriptEnabled(true);
        //webView.loadUrl("https://www.amalgama-lab.com/");
//
        //WebViewClient webViewClient = new WebViewClient() {
        //    @SuppressWarnings("deprecation")
        //    //@Override
        //    public boolean shouldOverrideUrlLoadings(WebView view, String url) {
        //        view.loadUrl(url);
        //        return true;
        //    }
//
        //    @TargetApi(Build.VERSION_CODES.N)
        //    //@Override
        //    public boolean shouldOverrideUrlLoadings(WebView view, WebResourceRequest request) {
        //        view.loadUrl(request.getUrl().toString());
        //        return true;
        //    }
        //};
        //webView.setWebViewClient(webViewClient);
    }
}