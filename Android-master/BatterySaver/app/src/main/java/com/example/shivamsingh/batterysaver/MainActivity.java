package com.example.shivamsingh.batterysaver;

import android.content.Context;
import android.media.AudioManager;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static int curVol ;
    static AudioManager audio;
    static float curBrightness;
    static WifiManager wifiManager;
    static int wifiStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //volume
        audio = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        curVol = audio.getStreamVolume(AudioManager.STREAM_MUSIC);

        //brightness
        try {
            curBrightness= Settings.System.getInt(getContentResolver(), Settings.System.SCREEN_BRIGHTNESS);
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }

        //wifi
        wifiManager = (WifiManager)this.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        wifiStatus = wifiManager.getWifiState();
        Toast.makeText(this, String.valueOf(wifiStatus), Toast.LENGTH_LONG).show();
    }

    public void start(View view) {

        //volume
        CheckBox volume = (CheckBox) findViewById(R.id.volume);
        if (volume.isChecked()) {
                audio.adjustStreamVolume(AudioManager.STREAM_MUSIC, -100, AudioManager.FLAG_SHOW_UI);
        }
        //brightness
        CheckBox brightness = (CheckBox) findViewById(R.id.brightness);
        if (brightness.isChecked()) {
                Settings.System.putInt(getApplicationContext().getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, 0);
        }

        CheckBox wifi = (CheckBox) findViewById(R.id.wifi);
        if (wifi.isChecked()) {
            wifiManager.setWifiEnabled(false);
        }else if (!volume.isChecked() && !brightness.isChecked() && !wifi.isChecked()) {
            Toast.makeText(this, "nothing to do", Toast.LENGTH_SHORT).show();
        }

    }

        public void stop(View view){
            //volume
            audio.adjustStreamVolume(AudioManager.STREAM_MUSIC, curVol, AudioManager.FLAG_SHOW_UI);

            //brightness
            Settings.System.putInt(getApplicationContext().getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, Math.round(curBrightness));

            //wifi
            wifiManager.setWifiEnabled(true);

        }
}