package com.corbishley.intentappget;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Context context;
    private ImageView imageViewPic;
    private TextView textViewTitle;
    private int textColor,newTextColor;
    private boolean pictureFlag,colorFlag;
    private final int groupID_1 = 1;
    private final int groupID_2 = 2;
    private final int groupID_3 = 3;
    private final int changePic = 1;
    private final int changeColor = 2;
    private final int actionSend = 3;
    private final int myIntent = 4;
    private final int playVideo = 5;
    private AlertDialog.Builder builder;
    private final int newItem = 10;
    private final int gameItem = 55;
    private static final String TAG = "main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        textViewTitle = (TextView) findViewById(R.id.textView_title);
        imageViewPic = (ImageView) findViewById(R.id.imageView_pic);

        textColor = textViewTitle.getCurrentTextColor();
        newTextColor = 0xff800080;
        pictureFlag = true;
        colorFlag = true;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(groupID_1,changePic, Menu.NONE,"Change Picture");
        menu.add(groupID_1,changeColor, Menu.NONE,"Change Color");
        menu.add(groupID_2,actionSend,Menu.NONE,"Select ActionSend");
        menu.add(groupID_2,myIntent,Menu.NONE,"Select My Intent");

        menu.add(groupID_3, playVideo, Menu.NONE,"Play Video");

        MenuItem item1 = menu.add(0,newItem,Menu.NONE,"HTTP");
        item1.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

        MenuItem item2 = menu.add(0, gameItem, Menu.NONE, "Game");
        item2.setIcon(R.drawable.game);
        item2.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String message;
        if (item.getGroupId() == groupID_1){

            message = item.getItemId()+":"+item.getTitle().toString();
            Toast.makeText(context,"message",Toast.LENGTH_SHORT).show();

            if(item.getItemId() == changePic){
                if (pictureFlag == true){
                    imageViewPic.setImageResource(R.drawable.stock_lock);
                    pictureFlag = false;
                }else {
                    imageViewPic.setImageResource(R.drawable.share);
                    pictureFlag = true;
                }
            }else{
                if (colorFlag == true){
                    textViewTitle.setTextColor(newTextColor);
                    colorFlag = false;
                }else{
                    textViewTitle.setTextColor(textColor);
                    colorFlag = true;
                }
            }
        }else if (item.getGroupId() == groupID_2){
            switch (item.getItemId()){

                case actionSend:
                    showDialog_1();
                    break;

                case myIntent:
                    showDialog_2();
                    break;
            }
        }else if (item.getGroupId() == groupID_3){
            if(item.getItemId() == playVideo){
                Intent intent = new Intent(context,playVideoActivity.class);
                startActivity(intent);
            }

        }else if (item.getItemId() == newItem){  //http

            String httpAddr = "tw.yahoo.com";
            String actionhttp = Intent.ACTION_VIEW;
           // Uri uriHttp = Uri.parse("http:"+httpAddr);
            Uri uriHttp = Uri.parse("http: "+" ");
            Log.d(TAG,"http uri = "+uriHttp);

            Intent intentHttp = new Intent(actionhttp, uriHttp);
            startActivity(intentHttp);

        }else if (item.getItemId() == gameItem){  //search

            String searchData = " ";
            String actionSearch = Intent.ACTION_WEB_SEARCH;

            Intent intentSearch = new Intent(actionSearch);
            intentSearch.putExtra(SearchManager.QUERY,searchData);
            startActivity(intentSearch);

        }
        return super.onOptionsItemSelected(item);
    }
    private void showDialog_1() {
        builder = new AlertDialog.Builder(context);
        builder.setTitle("Change Activity");
        builder.setMessage("Please confirm to change activity");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(context,IntentSendActivity.class);
                startActivity(intent);
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();  //按了之後對話框才會關掉
            }
        });
        builder.create().show();
    } // end of Dialog_1()

    private void showDialog_2() {
        builder = new AlertDialog.Builder(context);
        builder.setTitle("Change Activity");
        builder.setIcon(android.R.drawable.ic_dialog_info);
        builder.setMessage("Please confirm to change activity");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(context, GetIntentActivity.class);
                startActivity(intent);
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.setNeutralButton("No idea", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
