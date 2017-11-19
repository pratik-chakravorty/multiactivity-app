package com.pratik.cardviews;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    //declare the view objects
    private ImageView image;
    private TextView text;
    private TextView movieInfo;
    private TextView rating;
    private TextView genre;
    private Button moreInfo;
    private XMLParser parser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //sets the title of the current activity
        this.setTitle("Movie Information");

        //initlaize the view objects
        image = (ImageView)findViewById(R.id.secondActivityImage);
        text = (TextView)findViewById(R.id.secondTitle);
        movieInfo = (TextView)findViewById(R.id.movieInfoBox);
        rating = (TextView)findViewById(R.id.secondRating);
        genre = (TextView)findViewById(R.id.movieGenre);
        moreInfo =(Button)findViewById(R.id.more_info);

        //get data through intents
        Intent intent = getIntent();
        int id = intent.getIntExtra("image",0);

        //set the image resource
        image.setImageResource(id);

        String title = intent.getStringExtra("movieTitle");

        //set the title
        text.setText(title);

        String info = intent.getStringExtra("movieInfo");

        //set the movie information
        movieInfo.setText(info);

        String movieRating = intent.getStringExtra("movieRating");
        rating.setText(movieRating+"/10");

        String movieGenre = intent.getStringExtra("movieGenre");

        //set the genre
        genre.setText("Genre- "+movieGenre);

        //initialize the xml parser
        parser = new XMLParser(getApplicationContext());

        //get the position value
        final int position = intent.getIntExtra("pos",0);

        moreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(SecondActivity.this,ThirdActivity.class);
                MovieXML data = parser.getData(position);
                mIntent.putExtra("movieTitle",data.getMovieName());
                mIntent.putExtra("movieInfo",data.getMovieInfo());
                mIntent.putExtra("position",position);
                startActivity(mIntent);
            }
        });
    }


}
