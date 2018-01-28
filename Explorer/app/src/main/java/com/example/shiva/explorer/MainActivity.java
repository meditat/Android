package com.example.shiva.explorer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    String[] colors = {"Alizarin", "Amaranth", "Amber", "Amethyst", "Apricot", "Aqua", "Aquamarine", "Asparagus", "Auburn",
            "Azure", "Beige","Bistre", "Black", "Blue", "Blue Green", "Blue Violet", "Bondi Blue", "Brass", "Bronze", "Brown",
            "Buff", "Burgundy", "Burnt Orange", "Burnt Sienna", "Burnt Umber"};

///   String[] color = {"a", "b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    GridView gridView;
    boolean isGrid = true;
    ImageButton btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.grid_view);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, colors);
        btn = findViewById(R.id.btn);
        gridView.setAdapter(arrayAdapter);
    }

    public void changeView(View view) {
        if (isGrid) {
            gridView.setNumColumns(1);
            btn.setImageResource(R.drawable.grid);
            isGrid = false;
        } else {
            gridView.setNumColumns(GridView.AUTO_FIT);
            btn.setImageResource(R.drawable.list);
            isGrid = true;
        }
    }
}
