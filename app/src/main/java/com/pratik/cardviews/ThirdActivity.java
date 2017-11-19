package com.pratik.cardviews;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.TransitionInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    private TextView movietitle;
    private TextView movieInfo;
    private Button webInfo;
    private String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        this.setTitle("Movie XML Data");

        movietitle = (TextView)findViewById(R.id.thirdMovieTitle);
        movieInfo = (TextView)findViewById(R.id.thirdMovieInfo);
        webInfo = (Button)findViewById(R.id.webMovieInfo);

        Intent mIntent = getIntent();
        String title = mIntent.getStringExtra("movieTitle");
        String info = mIntent.getStringExtra("movieInfo");

        movietitle.setText(title);
        movieInfo.setText(info);

        final int position = mIntent.getIntExtra("position",0);

        switch(position) {
            case 0: url="https://www.rottentomatoes.com/m/the_dark_knight/";
            break;
            case 1: url="https://www.rottentomatoes.com/m/your_name_2017/";
            break;
            case 2: url="https://www.rottentomatoes.com/m/inception/";
            break;
            case 3: url="https://www.rottentomatoes.com/m/john_wick/";
            break;
            case 4: url="https://www.rottentomatoes.com/m/marvels_the_avengers/";
            break;
            case 5: url="https://www.rottentomatoes.com/m/star_wars_episode_vii_the_force_awakens/";

        }

        webInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThirdActivity.this,FourthActivity.class);
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });
    }

}
