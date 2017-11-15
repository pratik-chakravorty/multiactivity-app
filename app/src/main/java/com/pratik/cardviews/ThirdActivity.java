package com.pratik.cardviews;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.TransitionInflater;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    private TextView movietitle;
    private TextView movieInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);


        movietitle = (TextView)findViewById(R.id.thirdMovieTitle);
        movieInfo = (TextView)findViewById(R.id.thirdMovieInfo);

        Intent mIntent = getIntent();
        String title = mIntent.getStringExtra("movieTitle");
        String info = mIntent.getStringExtra("movieInfo");

        movietitle.setText(title);
        movieInfo.setText(info);
    }

}
