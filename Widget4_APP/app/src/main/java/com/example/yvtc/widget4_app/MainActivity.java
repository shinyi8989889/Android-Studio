package com.example.yvtc.widget4_app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView mealA,mealB;
    private TextView textViewResult;
    private RadioGroup radioGroup;
    private RadioButton radioA,radioB;
    private boolean mealAFlag,mealBFlag;
    private CheckBox checkCola,checkSaladA,checkFrenchfries,checkApplepie;
    private CheckBox checkSoup,checkSaladB,checkIceCream,checkChicken;
    private boolean colaFlag,saladAFlag,frenchfriesFlag,applePieFlag;
    private boolean soupFlag,saladBFlag,iceCreamFlag,chickenFlag;
    private Button okButton,cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mealA = (TextView) findViewById(R.id.textView_mealA);
        mealB = (TextView) findViewById(R.id.textView_mealB);
        mealA.setText("Hamburger Meal");
        mealB.setText("Chicken Meal");

        textViewResult = (TextView) findViewById(R.id.textView4_id);
        textViewResult.setText(" ");

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup_id);
        radioA = (RadioButton) findViewById(R.id.radioButton_A);
        radioB = (RadioButton) findViewById(R.id.radioButton_B);

        mealAFlag = false;
        mealBFlag = false;

        radioGroup.setOnCheckedChangeListener(new CheckedRadioChange());

        checkCola = (CheckBox) findViewById(R.id.checkBox_Cola);
        checkSaladA = (CheckBox) findViewById(R.id.checkBox_saladA);
        checkFrenchfries = (CheckBox) findViewById(R.id.checkBox_french);
        checkApplepie = (CheckBox) findViewById(R.id.checkBox_apple);

        checkSoup = (CheckBox) findViewById(R.id.checkBox_soup);
        checkSaladB = (CheckBox) findViewById(R.id.checkBox_saladB);
        checkIceCream = (CheckBox) findViewById(R.id.checkBox_iceCream);
        checkChicken = (CheckBox) findViewById(R.id.checkBox_chicken);

        checkCola.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(mealAFlag){
                    colaFlag = isChecked;
                }else {
                    checkCola.setChecked(false);
                    colaFlag = false;
                }
            }
        });

        checkSaladA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(mealAFlag){
                    saladAFlag = isChecked;
                }else {
                    checkSaladA.setChecked(false);
                    saladAFlag =false;
                }
            }
        });

        checkFrenchfries.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(mealAFlag){
                    frenchfriesFlag = isChecked;
                }else {
                    checkFrenchfries.setChecked(false);
                    frenchfriesFlag =false;
                }
            }
        });

        checkApplepie.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(mealAFlag){
                    applePieFlag = isChecked;
                }else {
                    checkApplepie.setChecked(false);
                    applePieFlag =false;
                }
            }
        });

        checkSoup.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(mealBFlag){
                    soupFlag = isChecked;
                }else {
                    checkSoup.setChecked(false);
                    soupFlag =false;
                }
            }
        });

        checkSaladB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(mealBFlag){
                    saladBFlag = isChecked;
                }else {
                    checkSaladB.setChecked(false);
                    saladBFlag =false;
                }
            }
        });

        checkIceCream.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(mealBFlag){
                    iceCreamFlag = isChecked;
                }else {
                    checkIceCream.setChecked(false);
                    iceCreamFlag =false;
                }
            }
        });

        checkChicken.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(mealBFlag){
                    chickenFlag = isChecked;
                }else {
                    checkChicken.setChecked(false);
                    chickenFlag =false;
                }
            }
        });

        okButton = (Button) findViewById(R.id.button_ok);
        cancelButton = (Button) findViewById(R.id.button_cancel);

        okButton.setOnClickListener(new buttonClick());
        cancelButton.setOnClickListener(new buttonClick());

    } // end of onCreat()

    private class CheckedRadioChange implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                case R.id.radioButton_A:
                    mealAFlag = true;
                    mealBFlag = false;

                    checkSoup.setChecked(false);
                    checkSaladB.setChecked(false);
                    checkIceCream.setChecked(false);
                    checkChicken.setChecked(false);
                    break;

                case R.id.radioButton_B:
                    mealAFlag = false;
                    mealBFlag = true;

                    checkCola.setChecked(false);
                    checkSaladA.setChecked(false);
                    checkFrenchfries.setChecked(false);
                    checkApplepie.setChecked(false);
                    break;
            }
        }
    }
    private class buttonClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.button_ok:
                    int orderSum = 0;
                    if(mealAFlag){

                        textViewResult.setText("Your order is Hamburger set :\n");
                        if(colaFlag) {
                            textViewResult.append("Cola drink\n");
                            orderSum += 50;
                        }
                        if(saladAFlag) {
                            textViewResult.append("Salad A\n");
                            orderSum += 100;
                        }
                        if(frenchfriesFlag) {
                            textViewResult.append("French fries\n");
                            orderSum += 60;
                        }
                        if(applePieFlag) {
                            textViewResult.append("Apple pir\n");
                            orderSum += 80;
                        }
                        textViewResult.append("Total:  "+orderSum);

                    }else if(mealBFlag){

                        textViewResult.setText("You chose chicken set :\n");
                        if(soupFlag) {
                            textViewResult.append("Soup\n");
                            orderSum += 80;
                        }
                        if(saladBFlag) {
                            textViewResult.append("Salad B\n");
                            orderSum += 100;
                        }
                        if(iceCreamFlag) {
                            textViewResult.append("Ice Cream\n");
                            orderSum += 90;
                        }
                        if(chickenFlag) {
                            textViewResult.append("Chicken nugget\n");
                            orderSum += 70;
                        }

                        textViewResult.append("Total: "+orderSum);
                    }
                    break;

                case R.id.button_cancel:

                    textViewResult.setText(" ");
                    radioA.setChecked(true);
                    radioB.setChecked(false);
                    mealAFlag = true;
                    mealBFlag = false;

                    checkCola.setChecked(false);
                    colaFlag = false;

                    checkSaladA.setChecked(false);
                    saladAFlag = false;

                    checkFrenchfries.setChecked(false);
                    frenchfriesFlag = false;

                    checkApplepie.setChecked(false);
                    applePieFlag = false;

                    checkSoup.setChecked(false);
                    soupFlag = false;

                    checkSaladB.setChecked(false);
                    saladBFlag = false;

                    checkIceCream.setChecked(false);
                    iceCreamFlag = false;

                    checkChicken.setChecked(false);
                    chickenFlag = false;
                    break;


            }
        }
    }
}
