package com.flayingfrog.eventer;

import android.graphics.drawable.Drawable;

/**
 * Created by alejandro on 10/03/17.
 */

public class Event {
    String info;
    String name;
    String description; //small description of the event
    String date; //day and time? of the event
    Drawable image; //image of the event

    public Event(String info,String name,String description,String date,Drawable image) {
        this.info = info;
        this.name = name;
        this.description = description;
        this.date = date;
        this.image = image;
    }

    public String theInfo(){
        return this.info;
    }

    public String theName(){
        return this.name;
    }

    public String theDesc(){
        return this.description;
    }

    public String theDate(){
        return this.date;
    }

    public Drawable theImage(){
        return this.image;
    }




}
