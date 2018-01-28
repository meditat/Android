package com.example.shiva.autologin;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Objects;


public class MainActivity extends AppCompatActivity {

    static String username = "Default";
    static String password = "Default";
    EditText userEdt;
    EditText passEdt;
    Button save;
    Button cancel;
    AlertDialog alertDialog;
    WifiManager wifiManager;
    WifiInfo info;
    String wifiInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Auto Login");
        actionBar.setSubtitle(R.string.for_abes);
        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        assert wifiManager != null;
        info = wifiManager.getConnectionInfo();
        wifiInfo = "SSID - " + info.getSSID() + '\n';
        wifiInfo = wifiInfo + "Mac Address - " + info.getMacAddress() + "\n";
        wifiInfo = wifiInfo + "Hidden SSID - " + info.getHiddenSSID() + "\n";
        wifiInfo = wifiInfo + "Ip Address - " + info.getIpAddress() + "\n";
        wifiInfo = wifiInfo + "Network ID - " + info.getNetworkId() + "\n";
        TextView textView = findViewById(R.id.wifi_info);
        textView.setText(wifiInfo);
        if (Objects.equals(info.getSSID(), "ABESEC")){
            Toast.makeText(this, "you are connected to Abesec", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        MenuItem wifiMenuItem = menu.findItem(R.id.wifi_status);
        if (wifiManager.isWifiEnabled()){
            wifiMenuItem.setIcon(R.drawable.wifi_on);
        }else {
            wifiMenuItem.setIcon(R.drawable.wifi_off);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.login_cred:
                showLoginScreen();
                break;
            case R.id.wifi_status:
                if (!wifiManager.isWifiEnabled()) {
                    wifiManager.setWifiEnabled(true);
                    item.setIcon(R.drawable.wifi_on);
                } else {
                    wifiManager.setWifiEnabled(false);
                    item.setIcon(R.drawable.wifi_off);
                }
                break;
            case R.id.refresh:
                recreate();
                break;
            case R.id.savedCred:
//                Toast.makeText(this, "Username : " + username + " Password " + password, Toast.LENGTH_SHORT).show();
                read();

        }
        return super.onOptionsItemSelected(item);
    }

    public void showLoginScreen() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View view = layoutInflater.inflate(R.layout.login_credentials, null, false);
        builder.setView(view);
        alertDialog = builder.create();
        alertDialog.setTitle("Login Credentials");
        alertDialog.show();

        userEdt = view.findViewById(R.id.username);
        passEdt = view.findViewById(R.id.password);
        save = view.findViewById(R.id.save);
        cancel = view.findViewById(R.id.cancel);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = userEdt.getText().toString();
                password = passEdt.getText().toString();
                alertDialog.dismiss();
                write(username, password);
                Toast.makeText(MainActivity.this, "Credentials saved", Toast.LENGTH_SHORT).show();

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
    }

    // write text to file
    public void write(String username, String password) {
        // add-write text into file
        try {
            FileOutputStream fileOut = openFileOutput("mytextfile.txt", MODE_PRIVATE);
            OutputStreamWriter outputWriter = new OutputStreamWriter(fileOut);
            outputWriter.write(username + "\n" + password);
            outputWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void read() {
        //reading text from file
        try {
            FileInputStream fileIn = openFileInput("mytextfile.txt");
            InputStreamReader InputRead = new InputStreamReader(fileIn);


            char[] inputBuffer = new char[30];
            StringBuilder s= new StringBuilder();
            int charRead;

            int i =0;
            while ((charRead = InputRead.read(inputBuffer)) > 0) {
                // char to string conversion
                String readString = String.copyValueOf(inputBuffer, 0, charRead);
                s.append(readString);
                i++;
                Log.d("something", "read: "+ i);
            }
            InputRead.close();
            Toast.makeText(getBaseContext(), s.toString(), Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void fillInfo(String useer, String pass){
        WebDriver webDriver = new ChromeDriver();
    }

}
