package com.pratik.cardviews;

import java.io.Serializable;

/**
 * Created by Pratik on 11/14/2017.
 * The movie info class is used for fetching the movie data that will be used in the second
 * activity
 */

public class MovieInfo implements Serializable{
    String movieInfo = null;
    String genre = null;

    public MovieInfo(String genre,String movieInfo) {
        this.movieInfo = movieInfo;
        this.genre = genre;
    }

    public String getMovieInfo() {
        return movieInfo;
    }

    public String getGenre() {
        return genre;
    }
}
