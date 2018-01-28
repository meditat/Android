package com.example.shiva.mymenuapplication;

import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    String[] array = {"Shivam" ,"Shardul", "Soniya", "Shalu", "Sohel"};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Home");
        actionBar.setSubtitle("Home sweet home");
        actionBar.setIcon(R.drawable.ic_android_black_24dp);

        listView= findViewById(R.id.list_item);
        ArrayAdapter adapter = new ArrayAdapter(this , android.R.layout.simple_list_item_1 , array);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId){
            case R.id.red:
                Toast.makeText(this, "red Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.green:
                Toast.makeText(this, "green Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.blue:
                Toast.makeText(this, "blue Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.another:
                Toast.makeText(this, "another Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nothing:
                Toast.makeText(this, "nothing Clicked", Toast.LENGTH_SHORT).show();
                break;
        }

        return  true;
    }

    public void doSomething(View view) {
        PopupMenu popupMenu = new PopupMenu(this,findViewById(R.id.doSomething), Gravity.TOP);
        popupMenu.getMenuInflater().inflate(R.menu.my_menu , popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int itemId = item.getItemId();
                switch (itemId){
                    case R.id.red:
                        Toast.makeText(getApplicationContext(), "red Clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.green:
                        Toast.makeText(getApplicationContext(), "green Clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.blue:
                        Toast.makeText(getApplicationContext(), "blue Clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.another:
                        Toast.makeText(MainActivity.this, "another Clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nothing:
                        Toast.makeText(MainActivity.this, "nothing Clicked", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Share");
        menu.add(0,0,0,"Whatsapp");
        menu.add(0,0,0,"Hike");
        menu.add(0,0,0,"ShareIt");
        menu.add(0,0,0,"Viber");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        String itemTitle = item.getTitle().toString();

        AdapterView.AdapterContextMenuInfo info= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int position=info.position;
        String listTittle=listView.getItemAtPosition(position).toString();
        if (Objects.equals(itemTitle, "Whatsapp")){
            Toast.makeText(this, "You selected whatsapp"+ "option for "  + listTittle, Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);

    }


}
