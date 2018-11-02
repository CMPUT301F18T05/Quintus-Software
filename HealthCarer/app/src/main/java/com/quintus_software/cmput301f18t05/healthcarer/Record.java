package com.quintus_software.cmput301f18t05.healthcarer;

import android.location.Location;
import android.media.Image;

import java.util.ArrayList;
import java.util.Calendar;

public class Record {
    private String title;
    private Calendar date;
    private ArrayList<Image> imageList = new ArrayList<Image>();
    private Location location;
    private String comment;
    private String type;

    Record(String title, Calendar date, Location location, String comment, String type) {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    // Not sure whether to return imageList or specific image.
//    public ArrayList<Image> getImageList() {
//        return imageList;
//    }

    public void addPhoto(Image image) {
        this.imageList.add(image);
    }

    public Image getPhoto(Integer index) {
        return this.imageList.get(index);
    }

    public Location getLocation() {
        return location;
    }

    public void deletePhoto(Integer index) {
        this.imageList.remove(index);
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}