package com.example.shiva.bluetoothaccess;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Set;


public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ActionBar actionBar;
    BluetoothAdapter bluetoothAdapter;
    int REQUEST_CODE = 30;
    Set<BluetoothDevice> pairedDevices;
    TextView pairedDevice;
    String deviceName ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Bluetooth Access");
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        pairedDevice = findViewById(R.id.pairedDevices);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.onOff);
        if (!bluetoothAdapter.isEnabled())
            menuItem.setIcon(R.drawable.bt_off);
        else menuItem.setIcon(R.drawable.bt_on);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.onOff:
                enableBT(item);
                break;
            case R.id.scan:
                getBondedDevices();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void enableBT(MenuItem item) {
        if (!bluetoothAdapter.isEnabled()) {
            Intent enableBT = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBT, REQUEST_CODE);
            item.setIcon(R.drawable.bt_on);
        } else {
            bluetoothAdapter.disable();
            item.setIcon(R.drawable.bt_off);
        }
    }

    public void getBondedDevices(){
        pairedDevices = bluetoothAdapter.getBondedDevices();
        if (pairedDevices.size() > 0) {
            // There are paired devices. Get the name and address of each paired device.
            for (BluetoothDevice device : pairedDevices) {
               deviceName += device.getName() +"\n";
            }
        }
        pairedDevice.setText(deviceName);

    }


}
