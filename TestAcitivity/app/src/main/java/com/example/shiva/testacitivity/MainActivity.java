package com.example.shiva.testacitivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.PopupWindow;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    ImageView imageView;
    Context context = MainActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showOptionMenu(View view) {

        int x1 = (int) view.getX();
        int y1 = (int) view.getY();
        LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
        View v = inflater.inflate(R.layout.popup_window, null);
        Dialog dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        WindowManager.LayoutParams wmlp = dialog.getWindow().getAttributes();
        wmlp.gravity = Gravity.TOP | Gravity.LEFT;
        wmlp.x = x1;   //x position
        wmlp.y = y1;   //y position
        dialog.setContentView(v);
        dialog.show();
        imageView = findViewById(R.id.image);
    }


    public void takePic(View view) {
        intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 1);

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == 1) {
                Uri selectedImageUri = data.getData();
                Picasso.with(context).load(selectedImageUri).into(imageView);
            }
        }
    }

    public void showChooser(View view) {
    }

    public void share(View view) {
    }

    public void openSMS(View view) {
    }

    public void dial(View view) {
    }

    public void openContacts(View view) {
    }

    public void openGallery(View view) {
    }

    public void makeVideo(View view) {
    }
}
