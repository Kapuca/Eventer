package com.flayingfrog.eventer;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Test1 extends AppCompatActivity {

    private EditText desc;
    private ImageButton ok;
    private ImageButton bad;
    private ImageView picture;

    private int index = 0;

    private int[] pictures = {
            R.drawable.twy,
            R.drawable.tmp,
            R.drawable.kp,
    };



    private String[] info = new String[]{
            "The wonder years in London",
            "Tiny moving parts in Madrid",
            "Knuckle Puck in Paris",
    };





    @Override // This works as the "main" of the project, thus all the functions will occur at the begining.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test1);


        picture = (ImageView) findViewById(R.id.imagen);

        desc = (EditText) findViewById(R.id.info);

        Drawable d = getResources().getDrawable(pictures[index]);

        picture.setImageDrawable(d);


        desc.setText(info[index]);




    }


    public void ticClicked(View view){

        picture = (ImageView) findViewById(R.id.imagen);

        desc = (EditText) findViewById(R.id.info);

        Drawable d = getResources().getDrawable(pictures[index]);

        picture.setImageDrawable(d);


        desc.setText(info[index]);


        //I would like to send the picture and the info that was "accepted" by the user to "my events"


        index=(index+1)%(pictures.length);


    }

    public void crossClicked(View view){

        picture = (ImageView) findViewById(R.id.imagen);

        desc = (EditText) findViewById(R.id.info);

        Drawable d = getResources().getDrawable(pictures[index]);

        picture.setImageDrawable(d);

        desc.setText(info[index]);

        index=(index+1)%(pictures.length);

    }



}
