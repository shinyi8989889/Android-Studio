package com.corbishley.intentshare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    private EditText inputData1,inputData2;
    private Button data1Button,data2Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputData1 = (EditText) findViewById(R.id.editText_data1);
        inputData2 = (EditText) findViewById(R.id.editText_data2);

        data1Button = (Button) findViewById(R.id.button_data1);
        data2Button = (Button) findViewById(R.id.button_data2);

        data1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String shareText = inputData1.getText().toString();
                Intent sendIntent = new Intent();

                String action = Intent.ACTION_SEND;
                sendIntent.setAction(action);
                sendIntent.setType("text/plain");
                sendIntent.putExtra(Intent.EXTRA_TEXT,shareText);
                startActivity(Intent.createChooser(sendIntent,"Please select APP"));
            }
        });

        data2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myText = inputData2.getText().toString();
                Intent intent = new Intent();
                intent.setAction("MyIntent");
                intent.putExtra("data",myText);

                startActivity(Intent.createChooser(intent,"Please select APP"));
            }
        });
    }
}
