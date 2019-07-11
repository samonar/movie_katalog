package com.example.moviekatalog;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private String title;
    private String description;
    private String genre;
    private String release;
    private String rating;
    private int poster;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }



    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString (this.title);
        dest.writeString (this.description);
        dest.writeString (this.genre);
        dest.writeString (this.release);
        dest.writeInt (this.poster);
    }

    public Movie() {
    }

    protected Movie(Parcel in) {
        this.title = in.readString ( );
        this.description = in.readString ( );
        this.genre = in.readString ( );
        this.release = in.readString ( );
        this.poster = in.readInt ( );
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie> ( ) {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie (source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
