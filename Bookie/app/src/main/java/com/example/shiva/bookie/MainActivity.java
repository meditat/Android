package com.example.shiva.bookie;



import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {
    BottomNavigationView navigation;
    Toolbar toolbar;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.my_toolbar);
        toolbar.setTitle("Books");
        setSupportActionBar(toolbar);
        navigation = findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_books);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) navigation.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationBehavior());

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(R.id.fragment_type, new BooksFragment());
        ft.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.sell_book:
                postABook();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.navigation_profile:
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        toolbar.setElevation(0);
                    }
                    toolbar.setTitle("Profile");
                    loadFragment(new ProfileFragment());
                    return true;
                case R.id.navigation_ebooks:
                    toolbar.setTitle("E-Books");
                    loadFragment(new EBookFragment());
                    return true;
                case R.id.navigation_books:
                    toolbar.setTitle("Books");
                    loadFragment(new BooksFragment());

                    return true;
                case R.id.navigation_audio_books:
                    toolbar.setTitle("Audio Books");
                    loadFragment(new AudioBooksFragment());

                    return true;
                case R.id.navigation_cart:
                    toolbar.setTitle("Your Cart");
                    loadFragment(new CartFragment());
                    return true;
            }
            return true;
        }
    };

    public void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.fragment_type, fragment);
        ft.commit();
    }

    public void postABook(){
        Intent postActivity =  new Intent(MainActivity.this , PostBook.class);
        startActivity(postActivity);
    }
}