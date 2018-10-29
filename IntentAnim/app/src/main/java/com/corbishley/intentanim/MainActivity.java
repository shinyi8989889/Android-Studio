package com.corbishley.intentanim;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends Activity {

    private static final String TAG = "main";
    private Context context;
    private ImageButton imageButton1,imageButton2,imageButton3,imageButton4,imageButton5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        imageButton1 = (ImageButton) findViewById(R.id.imageButton1);
        imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        imageButton3 = (ImageButton) findViewById(R.id.imageButton3);
        imageButton4 = (ImageButton) findViewById(R.id.imageButton4);
        imageButton5 = (ImageButton) findViewById(R.id.imageButton5);

        imageButton1.setOnClickListener(new imageClick());
        imageButton2.setOnClickListener(new imageClick());
        imageButton3.setOnClickListener(new imageClick());
        imageButton4.setOnClickListener(new imageClick());
        imageButton5.setOnClickListener(new imageClick());

    }

    private class imageClick implements View.OnClickListener {
        private String name;
        private ActivityOptions option;

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, DisplayActivity.class);

            switch (v.getId()){

                case R.id.imageButton1:
                    name = getResources().getString(R.string.taiwan);
                    Log.d(TAG,"name = "+name);
                    intent.putExtra("title",name);
                    intent.putExtra("imageID",R.drawable.banner1);
                    intent.putExtra("stringID",R.string.taiwan_info);
                    imageButton1.setTransitionName(name);
                    option = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,imageButton1,name);
                    break;

                case R.id.imageButton2:
                    name = getResources().getString(R.string.sanya);
                    Log.d(TAG,"name = "+name);
                    intent.putExtra("title",name);
                    intent.putExtra("imageID",R.drawable.banner2);
                    intent.putExtra("stringID",R.string.sanya_info);
                    imageButton2.setTransitionName(name);
                    option = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,imageButton2,name);
                    break;

                case R.id.imageButton3:
                    name = getResources().getString(R.string.chengde);
                    Log.d(TAG,"name = "+name);
                    intent.putExtra("title",name);
                    intent.putExtra("imageID",R.drawable.banner3);
                    intent.putExtra("stringID",R.string.chengde_info);
                    imageButton3.setTransitionName(name);
                    option = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,imageButton3,name);
                    break;

                case R.id.imageButton4:
                    name = getResources().getString(R.string.great_wall);
                    Log.d(TAG,"name = "+name);
                    intent.putExtra("title",name);
                    intent.putExtra("imageID",R.drawable.banner4);
                    intent.putExtra("stringID",R.string.great_wall_info);
                    imageButton4.setTransitionName(name);
                    option = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,imageButton4,name);
                    break;

                case R.id.imageButton5:
                    name = getResources().getString(R.string.chong_cing);
                    Log.d(TAG,"name = "+name);
                    intent.putExtra("title",name);
                    intent.putExtra("imageID",R.drawable.banner5);
                    intent.putExtra("stringID",R.string.chong_cing_info);
                    imageButton5.setTransitionName(name);
                    option = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,imageButton5,name);
                    break;

            } // end of switch
            //startActivity(intent);
            startActivity(intent, option.toBundle());
        }
    }
}
