package com.example.yvtc.widget3_app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Button button1,button2,button3;
    private TextView text1,text2,text3;
    private ImageButton imageButton1,imageButton2,imageButton3,imageButton4,imageButton5,imageButton6;
    private View.OnClickListener buttonClick;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        button1 = (Button) findViewById(R.id.button_id1);
        button2 = (Button) findViewById(R.id.button_id2);
        button3 = (Button) findViewById(R.id.button_id3);

        text1 = (TextView) findViewById(R.id.textView_id1);
        text2 = (TextView) findViewById(R.id.textView_id2);
        text3 = (TextView) findViewById(R.id.textView_id3);

        text1.setText(" ");
        text2.setText(" ");
        text3.setText(" ");

        imageButton1 = (ImageButton) findViewById(R.id.imageButton_id1);
        imageButton2 = (ImageButton) findViewById(R.id.imageButton_id2);
        imageButton3 = (ImageButton) findViewById(R.id.imageButton_id3);
        imageButton4 = (ImageButton) findViewById(R.id.imageButton_id4);
        imageButton5 = (ImageButton) findViewById(R.id.imageButton_id5);
        imageButton6 = (ImageButton) findViewById(R.id.imageButton_id6);

//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                text1.setTextSize(24);
//                text1.setText("Button 1 is pressed.");
//                text2.setText(" ");
//                text3.setText(" ");
//            }
//        });

        buttonClick = new myButtonClass();
        button2.setOnClickListener(buttonClick);
        button3.setOnClickListener(buttonClick);
        button1.setOnClickListener(buttonClick);

        imageButton1.setOnClickListener(new myImageClass());
        imageButton2.setOnClickListener(new myImageClass());
        imageButton3.setOnClickListener(new myImageClass());
        imageButton4.setOnClickListener(new myImageClass());
        imageButton5.setOnClickListener(new myImageClass());
        imageButton6.setOnClickListener(new myImageClass());

    }   //end of onCreate()

    private class myButtonClass implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.button_id2:
                    text1.setText(" ");
                    text3.setText(" ");
                    text2.setText("Button 2 is pressed.");
                    break;

                case R.id.button_id3:
                    text1.setText(" ");
                    text2.setText(" ");
                    text3.setText("Button 3 is pressed.");
                    break;

                case R.id.button_id1:
                    text1.setTextSize(24);
                    text3.setText(" ");
                    text2.setText(" ");
                    text1.setText("Button 1 is pressed.");
            }
        }
    }

    private class myImageClass implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch(v.getId())
            {
                case R.id.imageButton_id1:
                    Toast.makeText(context,"Image button 1.",Toast.LENGTH_SHORT).show();
                    break;

                case R.id.imageButton_id2:
                    Toast.makeText(context, "Image button 2.",Toast.LENGTH_SHORT).show();
                    break;

                case R.id.imageButton_id3:
                    Toast.makeText(context, "Image button 3.",Toast.LENGTH_SHORT).show();
                    break;

                case R.id.imageButton_id4:
                    Toast.makeText(context, "Image button 4.",Toast.LENGTH_SHORT).show();
                    break;

                case R.id.imageButton_id5:
                    Toast.makeText(context, "Image button 5.",Toast.LENGTH_SHORT).show();
                    break;

                case R.id.imageButton_id6:
                    Toast.makeText(context, "Image button 6.",Toast.LENGTH_SHORT).show();
                    break;

            }
        }
    }
}
