package com.example.shiva.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   EditText num1;
   EditText num2;
   TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         num1 = findViewById(R.id.num1);
         num2 = findViewById(R.id.num2);
         output = findViewById(R.id.output);
    }


//    public void minus(View view) {
//        double firstNumber = Double.parseDouble(num1.getText().toString());
//        double secondNumber = Double.parseDouble(num2.getText().toString());
//        double answer = firstNumber- secondNumber;
//        output.setText("OUTPUT : "+ answer);
//    }
//
//    public void plus(View view) {
//        double firstNumber = Double.parseDouble(num1.getText().toString());
//        double secondNumber = Double.parseDouble(num2.getText().toString());
//        double answer = firstNumber + secondNumber;
//        output.setText("OUTPUT :"+ answer);
//    }
//
//    public void cross(View view) {
//        double firstNumber = Double.parseDouble(num1.getText().toString());
//        double secondNumber = Double.parseDouble(num2.getText().toString());
//        double answer = firstNumber * secondNumber;
//        output.setText("OUTPUT :"+ answer);
//    }
//
//    public void divide(View view) {
//        double firstNumber = Double.parseDouble(num1.getText().toString());
//        double secondNumber = Double.parseDouble(num2.getText().toString());
//        double answer = (firstNumber / secondNumber) + (firstNumber% secondNumber);
//        output.setText("OUTPUT :"+ answer);
//    }
//

//    public void calculate(View view){
//        double firstNumber = Double.parseDouble(num1.getText().toString());
//        double secondNumber = Double.parseDouble(num2.getText().toString());
//        int id = view.getId();
//        double answer = 0;
//        switch (id){
//
//            case R.id.plus :
//                answer = firstNumber + secondNumber;
//                break;
//            case R.id.minus :
//                answer = firstNumber - secondNumber;
//                break;
//            case R.id.cross :
//                answer = firstNumber * secondNumber;
//                break;
//            case R.id.divide :
//                answer = (firstNumber / secondNumber) + (firstNumber% secondNumber);
//                break;
//
//        }
//        output.setText(""+ answer);
//    }
}
