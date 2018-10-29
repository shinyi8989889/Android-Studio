package com.corbishley.menu2app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity {

    private static final String TAG = "main";
    private Context context;
    private TextView textViewTitle;
    private ImageView imageView1,imageView2,imageView3;
    private final int newItem = 1;
    private AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context =this;

        textViewTitle = (TextView) findViewById(R.id.textView_title);
        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageView3);

        imageView2.setVisibility(View.INVISIBLE);
        imageView3.setVisibility(View.INVISIBLE);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);

        MenuItem item = menu.add(0, newItem, Menu.NONE, "New");
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_mario:
                textViewTitle.setText("Mario game is enable");
                imageView2.setVisibility(View.VISIBLE);
                imageView2.setImageResource(R.drawable.mario);
                imageView1.setVisibility(View.INVISIBLE);
                imageView3.setVisibility(View.INVISIBLE);
                break;

            case R.id.menu_sonic:
                textViewTitle.setText("Sonic game is enable");
                imageView2.setVisibility(View.VISIBLE);
                imageView2.setImageResource(R.drawable.sonic);
                imageView1.setVisibility(View.INVISIBLE);
                imageView3.setVisibility(View.INVISIBLE);
                break;

            case R.id.menu_reset:
                textViewTitle.setText("menu game selection");
                imageView2.setVisibility(View.VISIBLE);
                imageView2.setImageResource(R.drawable.android_background);
                imageView1.setVisibility(View.INVISIBLE);
                imageView3.setVisibility(View.INVISIBLE);
                break;

            case R.id.menu_radio:
                textViewTitle.setText("Select picture : ");
                showDialog_3();
                break;
            //***********************1024**new***down********************
            case R.id.menu_checkbox:
                textViewTitle.setText("Select picture : ");
                showDialog_4();
                break;
            //*********************************up**************************
            case newItem:
                Toast.makeText(context,"New item is pressed.",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showDialog_3() {
        builder = new AlertDialog.Builder(context);
        builder.setTitle("Select one picture");

        builder.setSingleChoiceItems(R.array.picture, 1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                List<String> list = Arrays.asList(getResources().getStringArray(R.array.picture));
                Log.d(TAG,"list = "+list);
                String pictureNo = list.get(which);
                textViewTitle.append(pictureNo);
                if (which == 0){
                    imageView1.setVisibility(View.VISIBLE);
                    imageView1.setImageResource(R.drawable.img_1);
                    imageView2.setVisibility(View.INVISIBLE);
                    imageView3.setVisibility(View.INVISIBLE);
                }else if (which == 1){
                    imageView1.setVisibility(View.INVISIBLE);
                    imageView2.setImageResource(R.drawable.img_2);
                    imageView2.setVisibility(View.VISIBLE);
                    imageView3.setVisibility(View.INVISIBLE);
                }else{
                    imageView1.setVisibility(View.INVISIBLE);
                    imageView2.setVisibility(View.INVISIBLE);
                    imageView3.setVisibility(View.VISIBLE);
                    imageView3.setImageResource(R.drawable.img_3);
                }
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                imageView1.setVisibility(View.INVISIBLE);
                imageView2.setVisibility(View.INVISIBLE);
                imageView3.setVisibility(View.INVISIBLE);
                dialog.dismiss();
            }
        });

        builder.create().show();
    }

    //***********************1024*new***down***************************
    private void showDialog_4() {

        builder = new AlertDialog.Builder(context);
        builder.setTitle("Select picture");
        builder.setIcon(android.R.drawable.ic_dialog_info);
        final String[] pictureList = getResources().getStringArray(R.array.picture);
        final boolean[] checkList = new boolean[pictureList.length];

        builder.setMultiChoiceItems(pictureList, checkList, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                checkList[which] = isChecked;  // 哪一個被選到
                Log.d(TAG,"checkList = "+which + isChecked);
            }
        });

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                StringBuilder stringBuild = new StringBuilder();
                for (int i=0; i<checkList.length; i++){
                    if (checkList[i])
                        stringBuild.append(pictureList[i]+", ");
                }
                textViewTitle.append(stringBuild);

                if (checkList[0]){
                    imageView1.setVisibility(View.VISIBLE);
                    imageView1.setImageResource(R.drawable.img_1);
                }else {
                    imageView1.setVisibility(View.INVISIBLE);
                }

                if (checkList[1]){
                    imageView2.setVisibility(View.VISIBLE);
                    imageView2.setImageResource(R.drawable.img_2);
                }else {
                    imageView2.setVisibility(View.INVISIBLE);
                }

                if (checkList[2]){
                    imageView3.setVisibility(View.VISIBLE);
                    imageView3.setImageResource(R.drawable.img_3);
                }else {
                    imageView3.setVisibility(View.INVISIBLE);
                }
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.create().show();
    }
}  //*************************up*******************************************
