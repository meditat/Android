package com.example.shiva.costom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] names = { "Shivam " ,"Shardul " , "Sahil","Sane", "Somen", "Somendra","Soniya", "Som"};
    String[] info = {"An Android Developer" , "Web Developer" , "Ios Developer" ,"Back End Developer","An Android Developer" , "Web Developer" , "Ios Developer" ,"Back End Developer"};
    int[] images = {R.drawable.first_item, R.drawable.second_item, R.drawable.third_item, R.drawable.fourth_item,R.drawable.first_item, R.drawable.second_item, R.drawable.third_item, R.drawable.fourth_item};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyAdapter myAdapter = new MyAdapter(this ,names , info , images);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(myAdapter);
    }
}
