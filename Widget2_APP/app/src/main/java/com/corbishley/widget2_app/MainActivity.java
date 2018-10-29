package com.corbishley.widget2_app;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

    private static final String TAG = "APP2";
    private Button button1,button2,button3;
    private ImageView pictureView;
    private TextView pictureText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG,"onCreate() stage");

        button1 = (Button) findViewById(R.id.button1_id);
        button2 = (Button) findViewById(R.id.button2_id);
        button3 = (Button) findViewById(R.id.button3_id);

        pictureView = (ImageView) findViewById(R.id.imageView);
        pictureText = (TextView) findViewById(R.id.textView2_id);
        pictureText.setText(" ");

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pictureView.setImageResource(R.drawable.line1);
                pictureText.setText("This is picture 1.\n It is Line bear.\n");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pictureView.setImageResource(R.drawable.line2);
                pictureText.setText("This is picture 2.\n It is Line bear.\n");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pictureView.setImageResource(R.drawable.line3);
                pictureText.setText("This is picture 3.\n It is Line bear.\n");
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() stage.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() stage,");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() stage,");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() stage,");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() stage,");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart() stage,");
    }
}
