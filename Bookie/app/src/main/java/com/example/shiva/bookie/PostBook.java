package com.example.shiva.bookie;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;


public class PostBook extends AppCompatActivity {

    Toolbar doneToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_book);
        doneToolbar =  findViewById(R.id.done_toolbar);
        setSupportActionBar(doneToolbar);
    }
}
