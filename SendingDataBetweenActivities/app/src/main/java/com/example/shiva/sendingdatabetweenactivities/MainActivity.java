package com.example.shiva.sendingdatabetweenactivities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_SELECT_PIC = 12;
    static String EXTRA_MSG;
    EditText firstToSecond;
    int REQUEST_CODE = 1;
    TextView firstTv;
    String my_data;
    ImageView imageView;
    Context context = MainActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar myToolbar =  findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        firstToSecond = findViewById(R.id.activity_main_edt);
        firstTv = findViewById(R.id.firstTextView);
        imageView = findViewById(R.id.selectedImage);

    }


    public void sendToSecond(View view) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        EXTRA_MSG = firstToSecond.getText().toString();
        intent.putExtra("msg", EXTRA_MSG);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                my_data = data.getStringExtra("EXTRA_REPLY");
                Toast.makeText(this, my_data, Toast.LENGTH_SHORT).show();
                firstTv.setText(my_data);
            }
        }
        if (requestCode == REQUEST_SELECT_PIC){
            if (resultCode == RESULT_OK){
                Uri uri = data.getData();
                Toast.makeText(context, "image uri"+ uri, Toast.LENGTH_SHORT).show();
                Picasso.with(context).load(uri).into(imageView);
            }
        }
    }

    public void pickPhoto(View view) {
        Intent pickPhoto = new Intent(Intent.ACTION_GET_CONTENT);
        pickPhoto.setType("image/*");
        startActivityForResult(pickPhoto, REQUEST_SELECT_PIC);
    }
}
