package com.flayingfrog.eventer;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.R;


import java.util.ArrayList;
import java.util.List;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class Test1 extends AppCompatActivity {
    private GestureDetector gestureDetector;
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

    LoginButton loginButton;
    TextView textView5;
    CallbackManager callbackManager;



    @Override // This works as the "main" of the project, thus all the functions will occur at the begining.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.test1);


        picture = (ImageView) findViewById(R.id.imagen);

        desc = (EditText) findViewById(R.id.info);

        Drawable d = getResources().getDrawable(pictures[index]);

        picture.setImageDrawable(d);


        desc.setText(info[index]);

        gestureDetector = new GestureDetector(new Test1.SwipeGestureDetector());

        loginButton = (LoginButton)findViewById(R.id.login_button);
        textView5 = (TextView)findViewById(R.id.textView);
        callbackManager = CallbackManager.Factory.create();
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                textView5.setText("Login Sucess \n" +
                loginResult.getAccessToken().getUserId() +
                "\n" + loginResult.getAccessToken().getToken());

            }

            @Override
            public void onCancel() {
                textView5.setText("Login Cancelled");

            }

            @Override
            public void onError(FacebookException error) {

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode,resultCode,data);
    }

    public void ticClicked(View view){

        picture = (ImageView) findViewById(R.id.imagen);

        desc = (EditText) findViewById(R.id.info);

        Drawable d = getResources().getDrawable(pictures[index]);

        picture.setImageDrawable(d);


        desc.setText(info[index]);


        //I would like to send the picture and the info that was "accepted" by the user to "my events"
        //send it to the database


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

    @Override
        public boolean onTouchEvent(MotionEvent event) {
            if (gestureDetector.onTouchEvent(event)) {
                return true;
            }
            return super.onTouchEvent(event);
        }

        private void onLeftSwipe() {
            Intent intent = new Intent(this, MyEvents.class);
            startActivity(intent);
        }

        private void onRightSwipe() {


        }

        // Private class for gestures
        private class SwipeGestureDetector extends GestureDetector.SimpleOnGestureListener {
            // Swipe properties, you can change it to make the swipe
            // longer or shorter and speed
            private static final int SWIPE_MIN_DISTANCE = 120;
            private static final int SWIPE_MAX_OFF_PATH = 200;
            private static final int SWIPE_THRESHOLD_VELOCITY = 200;

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                try {
                    float diffAbs = Math.abs(e1.getY() - e2.getY());
                    float diff = e1.getX() - e2.getX();

                    if (diffAbs > SWIPE_MAX_OFF_PATH) {
                        return false;
                    }

                    // Left swipe
                    if (diff > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                        Test1.this.onLeftSwipe();

                        // Right swipe
                    } else if (-diff > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                        Test1.this.onRightSwipe();
                    }
                } catch (Exception e) {
                    Log.e("YourActivity", "Error on gestures");
                }
                return false;
            }
        }
    }

