package com.example.shiva.helloworld;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class ColorActivity extends AppCompatActivity {

    RelativeLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        layout = findViewById(R.id.relativeLayout);
    }

    public void changeColor(View view){
        int id  = view.getId();
        switch (id){
            case R.id.red:
                layout.setBackgroundColor(Color.RED);
                break;
            case R.id.green:
                layout.setBackgroundColor(Color.GREEN);
                break;
            case R.id.blue:
                layout.setBackgroundColor(Color.BLUE);
                break;
            case R.id.black:
                layout.setBackgroundColor(Color.BLACK);
                break;
            case R.id.orange:
                layout.setBackgroundColor(Color.parseColor("#fa470b"));
                break;

        }
    }
}
