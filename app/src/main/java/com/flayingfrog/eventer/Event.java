package com.flayingfrog.eventer;

import android.graphics.drawable.Drawable;

/**
 * Created by alejandro on 10/03/17.
 */

public class Event {
    String name;
    String description; //small description of the event
    String date; //day and time? of the event
    String time;
    Drawable image; //image of the event

    public Event(String name,String description,String date,String time,Drawable image) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.time=time;
        this.image = image;
    }


    public String theTime() {return this.time;}

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
