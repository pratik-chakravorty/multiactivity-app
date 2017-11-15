package com.pratik.cardviews;

/**
 * Created by Pratik on 10/30/2017.
 */

public class Cards {
    private int imageUrl;
    private String cardTitle;
    private String rating;

    public Cards(int imageUrl, String cardTitle, String rating) {
        this.imageUrl = imageUrl;
        this.cardTitle = cardTitle;
        this.rating = rating;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCardTitle() {
        return cardTitle;
    }

    public void setCardTitle(String cardTitle) {
        this.cardTitle = cardTitle;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
