package com.corbishley.intentappget;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class GetIntentActivity extends Activity {

    private TextView myData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_intent);

        setTitle("My Intent");

        myData = (TextView) findViewById(R.id.textView_myintent);

        Intent intent = getIntent();
        String data = intent.getStringExtra("data");
        myData.setText("My Intent data ="+data);

    }
}
