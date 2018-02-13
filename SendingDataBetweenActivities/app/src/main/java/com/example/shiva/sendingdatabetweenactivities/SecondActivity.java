package com.example.shiva.sendingdatabetweenactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView message;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar myToolbar =  findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        setContentView(R.layout.activity_second);
        Intent someMsg = getIntent();
        String msg = someMsg.getStringExtra("msg");
        message = findViewById(R.id.secondTextView);
        message.setText(msg);
        editText = findViewById(R.id.replyEdt);

    }


    public void Reply(View view) {
        String replyEdit = editText.getText().toString();
        Intent reply = new Intent();
        reply.putExtra("EXTRA_REPLY",replyEdit);
        setResult(RESULT_OK,reply);
        finish();
    }
}
