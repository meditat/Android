package com.example.shiva.menuopt;

import android.app.ProgressDialog;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;

import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.Toast;

import java.util.Objects;


public class MainActivity extends AppCompatActivity {
    boolean isListView = true;
    String[] colors = {"Alizarin", "Amaranth", "Amber", "Amethyst", "Apricot", "Aqua", "Aquamarine", "Asparagus", "Auburn",
            "Azure", "Beige", "Bistre", "Black", "Blue", "Blue Green", "Blue Violet", "Bondi Blue", "Brass", "Bronze", "Brown",
            "Buff", "Burgundy", "Burnt Orange", "Burnt Sienna", "Burnt Umber"};
    GridView gridView;
    private EditText email;
    private EditText password;
    private int menuLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setIcon(R.drawable.code);
        actionBar.setTitle("Home");
        gridView = findViewById(R.id.list_item);
//      Adapter adapter = new ArrayAdapter<>(this, R.layout.list_item, R.id.list_item, colors);
        Adapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, colors);
        gridView.setAdapter((ListAdapter) adapter);
        registerForContextMenu(gridView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public void moveToSecond(View view) {

//        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
//        startActivity(intent);

    }

    //       How to get the data from search view from action bar , i Don't know
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.gridListChngr:
                if (isListView) {
                    //Changing to Grid view
                    gridView.setNumColumns(GridView.AUTO_FIT);
                    item.setIcon(R.drawable.list);
                    //Creating popup menu
//                    PopupMenu  popupMenu = new PopupMenu(this ,findViewById(R.id.list_item), Gravity.END);
//                    popupMenu.getMenuInflater().inflate(R.menu.menu,popupMenu.getMenu());
//                    popupMenu.show();

                    isListView = false;
                } else {
                    //Changing to listView
                    gridView.setNumColumns(1);
                    item.setIcon(R.drawable.grid);
                    isListView = true;
                }
                break;
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Share");
        menu.setHeaderIcon(R.drawable.code);

        menu.add(0, 0, 0, "Whatsapp");
        menu.add(0, 0, 0, "Hike");
        menu.add(0, 0, 0, "ShareIt");
        menu.add(0, 0, 0, "Viber");
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        String itemTitle = item.getTitle().toString();

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int position = info.position;
        String listTittle = gridView.getItemAtPosition(position).toString();
        if (Objects.equals(itemTitle, "Whatsapp")) {
            Toast.makeText(this, "You selected whatsapp" + "option for " + listTittle, Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);

    }

    public void login(MenuItem item) {
        menuLogin = item.getItemId();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Login");
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View view = layoutInflater.inflate(R.layout.login_screen_layout, null, false);
        builder.setView(view);
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();

        email = view.findViewById(R.id.email);
        password = view.findViewById(R.id.password);
        Button loginBtn = view.findViewById(R.id.login_action);
        Button cancelBtn = view.findViewById(R.id.cancel_action);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailEntered = email.getText().toString();
                String passwordEntered = password.getText().toString();

                showProgressDialog("Please wait", "Checking your authenticity...", emailEntered, passwordEntered);

                alertDialog.dismiss();
            }
        });
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
    }

    public void showProgressDialog(String title, String msg, String email, String password) {
        ProgressDialog progressDialog = new ProgressDialog(this, android.app.AlertDialog.THEME_DEVICE_DEFAULT_DARK);
        progressDialog.setCancelable(false);
        progressDialog.setTitle(title);
        progressDialog.setMessage(msg);
        progressDialog.show();
        if (Objects.equals(email, "shivam.singh.calif@gmail.com") && Objects.equals(password, "password")) {
            progressDialog.setMessage("You are now logged in");

            progressDialog.cancel();
        } else {
            progressDialog.setMessage("You are not in out list, please Register");

            progressDialog.cancel();
        }
    }
}
