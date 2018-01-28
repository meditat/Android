package com.example.shiva.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;


public class MainActivity extends AppCompatActivity {

    BluetoothAdapter btAdapter;
    Toolbar toolbar;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btAdapter = BluetoothAdapter.getDefaultAdapter();
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        setTitleColor(R.color.colorAccent);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem btState = findViewById(R.id.btState);
        if (btAdapter == null) {
            Toast.makeText(this, "Device does not support bluetooth", Toast.LENGTH_SHORT).show();

        } else {
            if (btAdapter.isEnabled()) {
                btState.setIcon(R.drawable.bt_on);
            } else {
                btState.setIcon(R.drawable.bt_off);
            }
        }
        return super.onCreateOptionsMenu(menu);
    }


}
