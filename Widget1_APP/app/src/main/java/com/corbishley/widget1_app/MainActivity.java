package com.corbishley.widget1_app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

    private Button buttonPict1;
    private ImageView pictureView;
    private int flag =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonPict1 = (Button) findViewById(R.id.button1_id);

        pictureView = (ImageView)findViewById(R.id.imageView_id);

        buttonPict1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (flag == 1) {
                    pictureView.setImageResource(R.drawable.line1);
                    flag = 2;
                } else {
                    pictureView.setImageResource(R.drawable.line2);
                    flag = 1;
                }
            }
        });
    }
}
