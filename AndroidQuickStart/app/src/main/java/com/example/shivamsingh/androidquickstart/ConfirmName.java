package com.example.shivamsingh.androidquickstart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ConfirmName extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm_name);

        TextView textView= (TextView) findViewById(R.id.confirm_name_text);
        String name= getIntent().getStringExtra("name");
        textView.setText(name);

    }
}
