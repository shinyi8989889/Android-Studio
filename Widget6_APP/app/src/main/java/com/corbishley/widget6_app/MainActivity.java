package com.corbishley.widget6_app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText idEdit,nameEdit;
    private RadioGroup radioGroup;
    private TextView textViewResult;
    private boolean maleFlag,femaleFlag;
    private CheckBox checkSport,checkReading,checkPainting;
    private boolean sportFlag,readingFlag,paintingFlag;
    private Button okButton,cancelButton;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        idEdit = (EditText) findViewById(R.id.editText_id);
        nameEdit = (EditText) findViewById(R.id.editText_name);
        textViewResult = (TextView) findViewById(R.id.textView_result);
        textViewResult.setText("");

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup_id);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.radioButton_male:
                        maleFlag = true;
                        femaleFlag = false;
                        break;

                    case R.id.radioButton_female:
                        maleFlag = false;
                        femaleFlag = true;
                        break;
                }
            }
        });

        checkSport = (CheckBox) findViewById(R.id.checkBox_sport);
        checkReading = (CheckBox) findViewById(R.id.checkBox_reading);
        checkPainting = (CheckBox) findViewById(R.id.checkBox_painting);

        checkSport.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                sportFlag = isChecked;
            }
        });

        checkReading.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                readingFlag = isChecked;
            }
        });

        checkPainting.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                paintingFlag = isChecked;
            }
        });

        okButton = (Button) findViewById(R.id.button_ok);
        cancelButton = (Button) findViewById(R.id.button_cancel);

        okButton.setOnClickListener(new myButtonClick());
        cancelButton.setOnClickListener(new myButtonClick());
    }

    private class myButtonClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.button_cancel:
                    checkSport.setChecked(false);
                    checkReading.setChecked(false);
                    checkPainting.setChecked(false);
                    radioGroup.clearCheck();
                    maleFlag = false;
                    femaleFlag = false;
                    idEdit.setText("");
                    nameEdit.setText("");
                    textViewResult.setText("");
                    break;

                case R.id.button_ok:
                    textViewResult.setText("");
                    if(idEdit.length() ==0 || nameEdit.length() ==0){
                        Toast.makeText(context,"Please input ID and name!",Toast.LENGTH_SHORT).show();
                    }else{
                        String result = "ID: " + idEdit.getText().toString() + "\n" + "Name: " + nameEdit.getText() + "\n";
                        textViewResult.append(result);

                        if(maleFlag){
                            textViewResult.append("Gender: male");
                        }else if(femaleFlag){
                            textViewResult.append("Gender: Female");
                        }else{
                            Toast.makeText(context,"Please select the gender.",Toast.LENGTH_SHORT).show();
                        }

                        textViewResult.append("\n\nHobby: ");
                        if(sportFlag)
                            textViewResult.append("Sport ");

                        if(readingFlag)
                            textViewResult.append("Reading ");

                        if(paintingFlag)
                            textViewResult.append("Painting ");
                    }
                    break;
            }
        }
    }
}
