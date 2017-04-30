package com.flayingfrog.eventer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CreateorSee extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createor_see);
    }

    public void goToCreate(View view){

        Intent myIntent = new Intent(CreateorSee.this, Create.class);
        CreateorSee.this.startActivity(myIntent);

    }

    public void goToSee(View view){
        Intent myIntent = new Intent(CreateorSee.this, Test1.class);
        CreateorSee.this.startActivity(myIntent);
    }
}
