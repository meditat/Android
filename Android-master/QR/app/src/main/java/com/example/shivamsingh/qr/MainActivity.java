package com.example.shivamsingh.qr;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //All Views in xml
    private TextView buttonScan ,content ;

    //qr code scanner object
    private IntentIntegrator qrScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //View objects
        buttonScan = (TextView) findViewById(R.id.buttonScan);
        content =(TextView) findViewById(R.id.content);



        //initialising  scan object
        qrScan = new IntentIntegrator(this);

        //creating event listener
        buttonScan.setOnClickListener(this);
    }

    //Scan Result
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            //If Qr id empty
            if (result.getContents() == null) {
                Toast.makeText(this, "Result Not Found", Toast.LENGTH_LONG).show();
            } else {
                    //Getting the content
                    String info  =result.getContents();
                    content.setText(info);
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
    @Override
    public void onClick(View view) {
        //initialise code
        qrScan.initiateScan();
    }
}