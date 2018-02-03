package com.example.shiva.scrollview;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    BluetoothAdapter bluetoothAdapter;
    Set<BluetoothDevice> pairedDevices;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    }


    public void enable(View view) {
        if (bluetoothAdapter.isEnabled()) {
            Toast.makeText(this, "Already Enable", Toast.LENGTH_SHORT).show();
        } else {
            bluetoothAdapter.enable();
        }
    }

    public void disable(View view) {
        bluetoothAdapter.disable();
    }

    public void paired(View view) {
        pairedDevices = bluetoothAdapter.getBondedDevices();
        ArrayList<String> devices = new ArrayList<>();

        if (pairedDevices.size() > 0) {
            for (BluetoothDevice device : pairedDevices) {
                String deviceName = device.getName();
                devices.add(deviceName);
            }
        }
        listView = findViewById(R.id.list_item);
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, devices);
        listView.setAdapter(adapter);

    }


}
