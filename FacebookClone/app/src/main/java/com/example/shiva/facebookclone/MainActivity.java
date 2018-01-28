package com.example.shiva.facebookclone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    String[] names = { " Shivam " ,"Shardul " , "Sahil","Sane", "Somen", "Somendra","Soniya", "Som"};
    int[] profileImage = {R.drawable.first_item, R.drawable.second_item, R.drawable.third_item, R.drawable.fourth_item,R.drawable.first_item, R.drawable.second_item, R.drawable.third_item, R.drawable.fourth_item};
    int[] time = {1,2,3,4,5,6,7,8};
    String[] mainPost = {"Today google announce kotlin as the official language.","Today google announce kotlin as the official language.","Today google announce kotlin as the official language.","Today google announce kotlin as the official language.","Today google announce kotlin as the official language.","Today google announce kotlin as the official language.","Today google announce kotlin as the official language.","Today google announce kotlin as the official language."}; String[] whoLiked = { " You Shardul and 26 others " ,"shardul " , "sahil","sane", "somen", "somendra","soniya", "som"};
    int[] mainPostImage = {R.drawable.google ,R.drawable.google ,R.drawable.google ,R.drawable.google ,R.drawable.google ,R.drawable.google ,R.drawable.google ,R.drawable.google };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CustomAdapter customAdapter = new CustomAdapter(this, names , profileImage , time , mainPost, whoLiked , mainPostImage);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(customAdapter);

    }

}
