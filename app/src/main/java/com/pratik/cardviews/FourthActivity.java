package com.pratik.cardviews;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class FourthActivity extends AppCompatActivity {
    private ProgressBar mPb;
    private WebView webview;
    private String mHtmlString;
    private String infoContent;
    private String url;
    private ScrollView scroll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        //sets the title of the current activity
        this.setTitle("Movie Web Data");

        //check if the user is online or not
        if(isOnline()==false) {
            AlertDialog.Builder builder;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
            } else {
                builder = new AlertDialog.Builder(this);
            }
            builder.setTitle("No Internet")
                    .setMessage("Please connect to the internet")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // continue with delete
                           finish();

                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }


        //get the data using Intents
        Intent mIntent = getIntent();

        final String getUrl = mIntent.getStringExtra("url");

        //pass the url data from the intents to the global String variable url
        url = getUrl;

        //initialize the scrollview
        scroll = (ScrollView)findViewById(R.id.scrollView);


        //initialize the webview and the progress bar
        webview = (WebView)findViewById(R.id.webview);
        mPb = (ProgressBar) findViewById(R.id.activity_main_pb);

        //add javascript and other webview settings to the webview object
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setDomStorageEnabled(true);
        webview.getSettings().setBuiltInZoomControls(true);
        webview.setBackgroundColor(0);

        //initialize a custom webview client
        webview.setWebViewClient(new MyWebViewClient(this));
        webview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        //launch the asynctask for fetching the data from the web
        new MyAsyncTask().execute();
    }
    class MyAsyncTask extends AsyncTask<Void,Void,Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            //calling of this method will result in data extraction from a web-page inside web-view
            extractDatafromURL();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            //This is to ensure no null values are printed on the screen if the user is offline
            if(mHtmlString==null) {
                return;
            }
            //loads the extracted data from the webview.
            webview.loadData("<html><head><style>body{color:#fff;}a{text-decoration:none;color:#ccc;}</style></head>"+mHtmlString+infoContent+"</html>","text/html; charset=utf-8","UTF-8");
            super.onPostExecute(aVoid);

        }
    }
    private void extractDatafromURL() {
        //Using jsoup library to extract the DOM representation of the page and then extracting a specific data
        try {
            Document doc = Jsoup.connect(url).get();
            org.jsoup.nodes.Element content = doc.getElementById("movieSynopsis");
            Elements movieInfoContent = doc.getElementsByClass("content-meta");
            mHtmlString = content.toString();
            Elements select = movieInfoContent.select("a");
            for(org.jsoup.nodes.Element e:select) {
                String absURL = e.absUrl("href");
                e.attr("href",absURL);
            }
            infoContent = movieInfoContent.toString();
            Log.i("data",mHtmlString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onBackPressed() {
        //Making sure the back-button functionality is enabled within the webview

        if (webview.canGoBack()) { //if going back is possible in webview then go back within webview
            webview.goBack();
        } else {
            super.onBackPressed(); //otherwise go back within the app

        }


    }

    public void showProgressBar(int visibilityMode) {
        //Code for the progress-bar visibility
        mPb.setVisibility(visibilityMode);

    }

    //method to check if the user is online or not
    private boolean isOnline() {
        ConnectivityManager conMgr = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();

        if(netInfo == null || !netInfo.isConnected() || !netInfo.isAvailable()){
            return false;
        }
        return true;
    }
}
