package com.yihui.wanandroid.ui;

import android.annotation.SuppressLint;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.yihui.wanandroid.R;
import com.yihui.wanandroid.databinding.ActivityWebviewBinding;

import java.util.logging.Logger;

public class WebviewActivity extends AppCompatActivity {

    private ActivityWebviewBinding activityBinding;
    private String mUrl ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityBinding = DataBindingUtil.setContentView(this, R.layout.activity_webview);

        mUrl = (String) getIntent().getExtras().get("url");

        com.orhanobut.logger.Logger.d("url"+mUrl);
        initWebview();

        activityBinding.title.ivBack.setVisibility(View.VISIBLE);

        activityBinding.title.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    /**
     * 初始化web view
     */
    @SuppressLint("JavascriptInterface")
    private void initWebview() {
        WebSettings wSet = activityBinding.webview.getSettings();
        wSet.setJavaScriptEnabled(true);
        //适应分辨率
        wSet.setUseWideViewPort(true);
        wSet.setLoadWithOverviewMode(true);
        activityBinding.webview.loadUrl(mUrl);

        activityBinding.webview.setWebViewClient(new WebViewClient() {

            //在开始加载网页时会回调
            @Override
            public void onPageStarted(WebView webView, String s, Bitmap bitmap) {
                super.onPageStarted(webView, s, bitmap);

            }
            //加载错误的时候会回调
            @Override
            public void onReceivedError(WebView webView, int i, String s, String s1) {
                super.onReceivedError(webView, i, s, s1);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    return;
                }

            }

            //加载错误的时候会回调
            @Override
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (webResourceRequest.isForMainFrame()) {

                }
            }

            //加载完成的时候会回调
            @Override
            public void onPageFinished(WebView webView, String s) {

            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }




}
