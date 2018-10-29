package com.corbishley.bmi1_intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class BMIActivity extends Activity {

    private TextView BMIResult;
    private static final int ReturnData = 1;            //***********
    private static final int ReturnError = 2;            //*****************
    private Intent intent;                                 //**************

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        Intent bmiIntent = getIntent();
        setTitle("BMI result");

        BMIResult = (TextView) findViewById(R.id.textView_bmi);
        BMIResult.setText("");

        String name = bmiIntent.getStringExtra("name");
        int age = bmiIntent.getIntExtra("age",25);
        BMIResult.setText("\nName : "+name +"\nAge : "+age+"\n");

        double height = bmiIntent.getIntExtra("height",1)/100.0;

        //************down**********************
        if(height <0.3){
            intent = new Intent();
            intent.putExtra("bmi_error","Your height is wrong.");
            setResult(ReturnError,intent);
            finish();
        } //***********upper***********************

        double weight = bmiIntent.getIntExtra("weight",1);
        double BMIValue = weight/(height*height);

        NumberFormat nf = new DecimalFormat("##.00");   //取多少小數點
        String bmiString = nf.format(BMIValue);
        BMIResult.append("Your BMI value is : "+bmiString+"\n");

        //**************down****************************
        String msg = getBMImessage(BMIValue);
        BMIResult.append("Your weight is :"+msg);

        intent = new Intent();
        intent.putExtra("bmi_record",msg);
        intent.putExtra("bmi_value",BMIValue);
        setResult(ReturnData,intent);
        //**************upper***************************
    }

    //*****************down*********************************
    private String  getBMImessage(double BMIValue){

        String message;

        if(BMIValue >0 && BMIValue <20){
            message = getResources().getString(R.string.bmi_low);

        }else if(BMIValue >=20 && BMIValue <26){
            message = getResources().getString(R.string.bmi_normal);

        }else if(BMIValue >=26 && BMIValue <30){
            message = getResources().getString(R.string.bmi_high);

        }else if(BMIValue >=30 && BMIValue <50){
            message = getResources().getString(R.string.bmi_overhigh);

        }else{
            message = "BMI value is error";
        }

        return message;

    }
}
