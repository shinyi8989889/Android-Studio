package com.corbishley.bmi1_intent;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends Activity {

    private static final String TAG = "main";
    private static final int IntentRequestCode = 4;   //************
    private static final int ReturnData = 1;            //***********
    private static final int ReturnError = 2;            //*****************
    private Context context;
    private EditText userName,userAge,bmiHeight,bmiWeight;
    private TextView bmiResult;
    private ImageButton startButton;
    private int age;
    private String temp;
    private int height,weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        userName = (EditText) findViewById(R.id.editText_name);
        userAge = (EditText) findViewById(R.id.editText_age);
        bmiHeight = (EditText) findViewById(R.id.editText_height);
        bmiWeight = (EditText) findViewById(R.id.editText_weight);

        bmiResult = (TextView) findViewById(R.id.textView_result);
        bmiResult.setTextSize(20);  //***************
        bmiResult.setTextColor(0xff008080); //****************
        bmiResult.setText("");

        startButton = (ImageButton) findViewById(R.id.imageButton_start);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = userName.getText().toString();
                Log.d(TAG,"name = "+name);
                if(name.length()==0){
                    Toast.makeText(context,"Please input your name.",Toast.LENGTH_SHORT).show();
                }

                if(userAge.length()==0){
                    Toast.makeText(context,"Please input your age.",Toast.LENGTH_SHORT).show();
                    age = 1;   //沒有輸入的話還是會傳一個數值進去
                }else{
                    temp = userAge.getText().toString();  //用一個buffer
                    age = Integer.parseInt(temp);
                    Log.d(TAG,"age = "+age);
                }

                if(bmiHeight.length()==0 || bmiWeight.length()==0){
                    Toast.makeText(context,"Please input your height and weight.",Toast.LENGTH_SHORT).show();
                }else{
                    temp = bmiHeight.getText().toString();
                    height = Integer.parseInt(temp);
                    Log.d(TAG,"height = "+height);

                    temp = bmiWeight.getText().toString();
                    weight = Integer.parseInt(temp);
                    Log.d(TAG,"height = "+weight);

                    Intent intent = new Intent(context, BMIActivity.class);
                    intent.putExtra("name",name);
                    intent.putExtra("age",age);
                    intent.putExtra("height",height);
                    intent.putExtra("weight",weight);

                    //startActivity(intent);               //*************

                    startActivityForResult(intent,IntentRequestCode);    //***********
                }
            }
        });
    } // end of onCreate()

    //**********************************
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == IntentRequestCode){

            switch(resultCode){
                case ReturnData:
                    String record = data.getStringExtra("bmi_record");
                    double value = data.getDoubleExtra("bmi_value",0);
                    Log.d(TAG,"bmi_record ="+record);
                    Log.d(TAG,"bmi_value ="+value);

                    NumberFormat nf = new DecimalFormat("##.00");
                    bmiResult.setText("BMI value is : "+nf.format(value)+"\n");
                    bmiResult.append("Your weight is : "+record);
                    break;

                case ReturnError:
                    String msg = data.getStringExtra("bmi_error");
                    bmiResult.setText(msg);
                    break;
            }
        }
    }
}
