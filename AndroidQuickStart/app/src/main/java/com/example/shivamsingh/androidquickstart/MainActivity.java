package com.example.shivamsingh.androidquickstart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void confirmName(View view) {
        Intent intent= new Intent(this,ConfirmName.class );
        EditText text= (EditText) findViewById(R.id.activity_main_name);
        String name= text.getText().toString();
        intent.putExtra("name" , name);

        startActivity(intent);

    }
}
