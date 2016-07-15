package com.dssp.androidparcelabletest.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by dhanrajnaik522 on 7/6/2016.
 */
public class Movie implements Parcelable {

    private String name;
    private String genre;
    private String year;
    private String imageUrl;
    private String description;

    public Movie() {
    }

    public Movie(String name, String genre, String year, String imageUrl, String description) {
        this.name = name;
        this.genre = genre;
        this.year = year;
        this.imageUrl = imageUrl;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        //data to be passed from here
        dest.writeString(name);
        dest.writeString(genre);
        dest.writeString(year);
        dest.writeString(imageUrl);
        dest.writeString(description);

    }

    /**
     * CREATOR
     */
    public static final Parcelable.Creator CREATOR
            = new Parcelable.Creator() {
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }


        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    // "De-parcel object
    public Movie(Parcel in) {
        name = in.readString();
        genre = in.readString();
        year = in.readString();
        imageUrl = in.readString();
        description = in.readString();

    }

}
