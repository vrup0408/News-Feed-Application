package com.example.news;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class NewsDesc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_desc);

        WebView myWeb = (WebView)findViewById(R.id.news_web);
        WebSettings webSettings = myWeb.getSettings();
        webSettings.setJavaScriptEnabled(true);

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");

        myWeb.loadUrl(url);
    }
}