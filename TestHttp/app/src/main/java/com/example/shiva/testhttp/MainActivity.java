package com.example.shiva.testhttp;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WebView webView;
        String url = "https://www.facebook.com/";
        webView = new WebView(this);
        webView.getSettings().setJavaScriptEnabled(true); // enable javascript
        webView.getSettings().setUseWideViewPort(true);
        webView.canScrollHorizontally(View.LAYOUT_DIRECTION_RTL);


        final Activity activity = this;

        webView.setWebViewClient(new WebViewClient() {
            @SuppressWarnings("deprecation")
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
            }

            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onReceivedError(WebView view, WebResourceRequest req, WebResourceError rerr) {
                // Redirect to deprecated method, so you can use it in all SDK versions
                onReceivedError(view, rerr.getErrorCode(), rerr.getDescription().toString(), req.getUrl().toString());
            }
        });
        webView.loadUrl(url);
        setContentView(webView);
        String numOrmail = "usfdfgdfvfdgvf";
        String pwd = "you cant get it";
        final String js = "javascript:document.getElementsByName('usernmae').value = '" + numOrmail + "';document.getElementsByName('password').value='" + pwd + "';";
        webView.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView view, String url) {
                view.loadUrl(js);
                view.loadUrl("javascript:document.getElementById('logincaption').click()");
            }
        });
    }
}

