package com.flayingfrog.eventer;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Create extends AppCompatActivity {

    private static int RESULT_LOAD_IMG = 1;
    private Event e;
    private EditText name;
    private EditText desc;
    private EditText time;
    private EditText date;
    private ImageView image;
    private Button create;
    private Button selectImage;
    private String newName;
    private String newDesc;
    private String newDate;
    private String newTime;
    private Drawable newImage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_create);

        name = (EditText) findViewById(R.id.Name);
        desc = (EditText) findViewById(R.id.Description);
        time = (EditText) findViewById(R.id.Time);
        date = (EditText) findViewById(R.id.Date);
        create = (Button) findViewById(R.id.Create);
        selectImage = (Button) findViewById(R.id.select);
        image = (ImageView) findViewById(R.id.imagen);

        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //What you want to do
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
               newName= s.toString();

                }
        });


        desc.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //What you want to do
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                newDesc= s.toString();

            }
        });


        time.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //What you want to do
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }


            @Override
            public void afterTextChanged(Editable s) {
                newTime = s.toString();

            }
        });


        date.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //What you want to do
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                newDate = s.toString();

            }
        });


    }

    public void selectImage(View view){
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent, RESULT_LOAD_IMG);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            // When an Image is picked
            if (requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK
                    && null != data) {
                // Get the Image from data

                Uri selectedImage = data.getData();
                String[] filePathColumn = { MediaStore.Images.Media.DATA };

                // Get the cursor
                Cursor cursor = getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                // Move to first row
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                String imgDecodableString = cursor.getString(columnIndex);
                cursor.close();
                image = (ImageView) findViewById(R.id.imagen);
                // Set the Image in ImageView after decoding the String
                image.setImageBitmap(BitmapFactory.decodeFile(imgDecodableString));
                newImage = new BitmapDrawable(getResources(),BitmapFactory.decodeFile(imgDecodableString));

            } else {
                Toast.makeText(this, "You haven't picked Image",
                        Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG)
                    .show();
        }

    }

    public void createEvent(View view){
        e = new Event(newName,newDesc,newDate,newTime,newImage);


        //upload Event e to database


    }

}
