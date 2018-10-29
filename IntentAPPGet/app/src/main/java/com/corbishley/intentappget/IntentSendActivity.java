package com.corbishley.intentappget;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class IntentSendActivity extends Activity {

    private TextView getData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_send);

        setTitle("ACTION Send");

        getData = (TextView) findViewById(R.id.textView_sendaction);

        Intent intent = getIntent();
        String data = intent.getStringExtra(Intent.EXTRA_TEXT);
        getData.setText("Receive data = "+data);

    }
}
