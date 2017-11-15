package com.pratik.cardviews;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pratik on 10/30/2017.
 */

public class CustomListAdapter extends ArrayAdapter<Cards> {

    private Context mContext;
    private int mResource;

    private static class ViewHolder {
        TextView cardTitle;
        TextView rating;
        ImageView cardImage;
    }

     public CustomListAdapter(Context context, int resource, ArrayList<Cards> objects) {
        super(context,resource,objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

       final Cards model = getItem(position);
       final int positionValue = position;

        final View result;

        ViewHolder holder;

        if(convertView==null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource,parent,false);
            holder = new ViewHolder();
            holder.cardTitle = (TextView)convertView.findViewById(R.id.movieTitle);
            holder.cardImage = (ImageView)convertView.findViewById(R.id.imageView);
            holder.rating = (TextView)convertView.findViewById(R.id.rating);

            result = convertView;

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder)convertView.getTag();
            result = convertView;

        }
        holder.cardTitle.setText(model.getCardTitle());

        holder.cardImage.setImageResource(model.getImageUrl());
        holder.rating.setText("IMDB Rating- " + model.getRating());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),SecondActivity.class);
                intent.putExtra("image",model.getImageUrl());
                intent.putExtra("movieTitle",model.getCardTitle());
                intent.putExtra("movieRating",model.getRating());

                if(positionValue==0) {
                    MovieInfo info = ((new MovieData()).getDarkKnight());
                    intent.putExtra("movieInfo",info.getMovieInfo());
                    intent.putExtra("movieGenre",info.getGenre());
                } else if(positionValue==1) {
                    MovieInfo info = ((new MovieData()).getYourName());
                    intent.putExtra("movieInfo",info.getMovieInfo());
                    intent.putExtra("movieGenre",info.getGenre());
                } else if(positionValue==2) {
                    MovieInfo info = ((new MovieData()).getInception());
                    intent.putExtra("movieInfo",info.getMovieInfo());
                    intent.putExtra("movieGenre",info.getGenre());
                } else if(positionValue==3) {
                    MovieInfo info = ((new MovieData()).getJohnwick());
                    intent.putExtra("movieInfo",info.getMovieInfo());
                    intent.putExtra("movieGenre",info.getGenre());
                } else if(positionValue==4) {
                    MovieInfo info = ((new MovieData()).getAvengers());
                    intent.putExtra("movieInfo",info.getMovieInfo());
                    intent.putExtra("movieGenre",info.getGenre());
                } else if(positionValue==5) {
                    MovieInfo info = ((new MovieData()).getStarwars());
                    intent.putExtra("movieInfo",info.getMovieInfo());
                    intent.putExtra("movieGenre",info.getGenre());
                }

                intent.putExtra("pos",positionValue);

                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((MainActivity)mContext,
                        v,"cardImage");
                mContext.startActivity(intent,options.toBundle());
            }
        });


        return result;
    }
}
