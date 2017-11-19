package com.pratik.cardviews;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Pratik on 11/16/2017.
 */

public class MyWebViewClient extends WebViewClient {
    private FourthActivity fourth;

    MyWebViewClient (FourthActivity fourthActivity){
        fourth = fourthActivity;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        String baseUrl = "http://www.rottentomatoes.com";

        view.loadUrl(url);
        return true;
    }


    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        fourth.showProgressBar(View.VISIBLE);
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        fourth.showProgressBar(View.GONE);
    }
}
