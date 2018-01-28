package com.example.shiva.helloworld;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.nio.channels.CancelledKeyException;
import java.util.Calendar;
import java.util.List;

public class DictionaryApp extends AppCompatActivity {

    String[] names = {"sahul" , "sahil", "shiva" , "sonu" , "shardul", "shanu", "sneha" ,"soniya"};
    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary_app);

        Button v=findViewById(R.id.selectTime);
        v.setBackgroundResource(R.drawable.background);

        v.setPadding(16,16,16,16);
//        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.autocomplete);
//        ArrayAdapter arrayAdapter = new ArrayAdapter(this , android.R.layout.simple_list_item_1 , names );
//        ListView listView = findViewById(R.id.list_item);
//        ArrayAdapter arrayAdapter = new ArrayAdapter(this , android.R.layout.simple_list_item_1, names );
//        ArrayAdapter arrayAdapter = new ArrayAdapter(this , R.layout.list, R.id.list_item, names );
//        listView.setAdapter(arrayAdapter);
//        GridView gridView = findViewById(R.id.grid);
//        ArrayAdapter arrayAdapter = new ArrayAdapter(this , android.R.layout.simple_list_item_1 , names);
//        gridView.setAdapter(arrayAdapter);
         calendar= Calendar.getInstance();


    }

    public void showAlert(View view) {

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Exit");
        alert.setMessage("Do you want to continue?");
        alert.setPositiveButton("Yes!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        alert.create();
        alert.show();
    }


    public void loginForm(View view) {
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Login");
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View v = layoutInflater.inflate(R.layout.login_layout , null , false);
        alert.setView(v);

        Button login = v.findViewById(R.id.login);
        Button cancel = v.findViewById(R.id.cancel);
        final EditText emlEdt = v.findViewById(R.id.emailEdt);
        final EditText passEdt = v.findViewById(R.id.pasEdt);
        final AlertDialog dialog=alert.create();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emlEdt.getText().toString();
                String password = passEdt.getText().toString();
                Toast.makeText(DictionaryApp.this, "Email :" + email + "Password : " + password, Toast.LENGTH_SHORT).show();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             dialog.dismiss();
            }
        });

        dialog.show();
    }


    public void selectDate(View view) {

        int day  = calendar.get(Calendar.DAY_OF_MONTH) ;
        int month = calendar.get(Calendar.MONTH);
        final int year  = calendar.get(Calendar.YEAR);
        final TextView  tv = findViewById(R.id.dateSelected);
        tv.setText(day +"/"+ month +"/" +year);

        DatePickerDialog dPDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                String date = day +"/" + (month+1) +"/" + year;
                tv.setText(date);
            }
        },year,month,day);

        dPDialog.show();
    }

    public void selectTime(View view) {
        int hr = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);
        int sec = calendar.get(Calendar.SECOND);
        String  timeSelected = hr+":" + min +":" + sec ;
        final TextView  textView = findViewById(R.id.timeSelected);
        textView.setText(timeSelected);

        TimePickerDialog TPDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hr, int min) {
                String time = hr + " :" + min ;
                textView.setText(time);

            }
        },hr ,min , true );
        TPDialog.show();

    }

    public void showProgressBar(View view) {
       ASTask asTask= new ASTask();
       asTask.execute("inder");
    }

    class  ASTask extends AsyncTask<String , Integer , String>{
        ProgressDialog progressDialog ;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(DictionaryApp.this);
            progressDialog.setTitle("SHow something ");
            progressDialog.setMessage("something there");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... voids) {
            try {
                Thread.sleep(3000);} catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "name";
        }

        @Override
        protected void onPostExecute(String aVoid) {
            super.onPostExecute(aVoid);
            progressDialog.dismiss();
        }

    }

}
