package com.example.shiva.cloud;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button buttonDisplayToken;
    private TextView textViewToken;

    String[] array = {"xxxx","yyyy","zzzz"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void move(View view) {
        Intent passArray = new Intent(MainActivity.this ,Foru.class);
        Bundle bundle = new Bundle();
        bundle.putStringArray("my_array", array);
        startActivity(passArray , bundle);
        passArray.putExtras(bundle);
        startActivity(passArray);
    }
}
