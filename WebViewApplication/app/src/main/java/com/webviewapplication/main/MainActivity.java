package com.webviewapplication.main;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    public static int RANDOMNUMNER ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.webview);
        increaseNumber(this);
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        RANDOMNUMNER = sharedPreferences.getInt("RandomNumber",0);
        webView.loadUrl("http://play.tech-vault.com/http.php?rand="+RANDOMNUMNER);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.setWebViewClient(new OwnBrowser());


    }

    public static void increaseNumber(Context context){
        RANDOMNUMNER++;
        SharedPreferences sharedPreferences = context.getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt("RandomNumber",RANDOMNUMNER);
        edit.commit();
    }

   /* public static void increaseNumber(Context context){
        RANDOMNUMNER++;
        SharedPreferences sharedPreferences = context.getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt("RandomNumber",RANDOMNUMNER);
        edit.commit();
    }*/

    private class OwnBrowser extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            webView.loadUrl("http://play.tech-vault.com/http.php?rand="+RANDOMNUMNER);
            return true;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        startService(new Intent(this, MyService.class));
    }

    @Override
    protected void onPause() {
        super.onPause();
        startService(new Intent(this, MyService.class));
    }
}
