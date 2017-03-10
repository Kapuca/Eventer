import android.graphics.drawable.Drawable;

/**
 * Created by alejandro on 10/03/17.
 */

public class Event {
    private String[] info;
    private String[] name;
    private String[] description; //small description of the event
    private String[] date; //day and time? of the event
    private Drawable image; //image of the event

    public Event(String[] info,String[] name,String[] description,String[] date,Drawable image) {
        this.info = info;
        this.name = name;
        this.description = description;
        this.date = date;
        this.image = image;
    }

    public String[] theInfo(Event e){
        return e.info;
    }

    public String[] theName(Event e){
        return e.name;
    }

    public String[] theDesc(Event e){
        return e.description;
    }

    public String[] theDate(Event e){
        return e.date;
    }

    public Drawable theImage(Event e){
        return e.image;
    }




}
