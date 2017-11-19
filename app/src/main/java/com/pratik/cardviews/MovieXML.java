package com.pratik.cardviews;

import java.io.Serializable;

/**
 * Created by Pratik on 11/14/2017.
 * This class is uses for fetching the parsed xml data from the xmlparser
 */

public class MovieXML implements Serializable{
    String movieName;
    String movieInfo;

    public MovieXML(String movieName, String movieInfo) {
        this.movieName = movieName;
        this.movieInfo = movieInfo;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getMovieInfo() {
        return movieInfo;
    }
}
