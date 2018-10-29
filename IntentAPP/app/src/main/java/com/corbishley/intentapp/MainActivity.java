package com.corbishley.intentapp;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private static final String TAG = "main";
    private MainActivity context;
    private EditText intentData;
    private ImageButton phoneButton,emailButton,httpButton,searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        intentData = (EditText) findViewById(R.id.editText_input);

        phoneButton = (ImageButton) findViewById(R.id.imageButton_tel);
        emailButton = (ImageButton) findViewById(R.id.imageButton_email);
        httpButton = (ImageButton) findViewById(R.id.imageButton_http);
        searchButton = (ImageButton) findViewById(R.id.imageButton_search);

        phoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(intentData.length() == 0){
                    Toast.makeText(context,"Please input phone number.",Toast.LENGTH_SHORT).show();
                }

                String phoneNumber = intentData.getText().toString();
                String actionPhone = Intent.ACTION_DIAL;
                Uri uriTel = Uri.parse("tel:"+phoneNumber);
                Log.d(TAG,"tel uri = "+uriTel);

                Intent intentPhone = new Intent(actionPhone, uriTel);
                startActivity(intentPhone);
            }
        });

        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(intentData.length() == 0){
                    Toast.makeText(context,"Please input email address.",Toast.LENGTH_SHORT).show();
                }

                String emailAddr = intentData.getText().toString();
                String actionEmail = Intent.ACTION_SENDTO;
                Uri uriEmail = Uri.parse("mailto:"+emailAddr);
                Log.d(TAG,"email uri = "+uriEmail);

                Intent intentEmail = new Intent(actionEmail, uriEmail);
                startActivity(intentEmail);
            }
        });

        httpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(intentData.length() == 0){
                    Toast.makeText(context,"Please input http address.",Toast.LENGTH_SHORT).show();
                }

                String httpAddr = intentData.getText().toString();
                String actionhttp = Intent.ACTION_VIEW;
                Uri uriHttp = Uri.parse("http:"+httpAddr);
                Log.d(TAG,"http uri = "+uriHttp);

                Intent intentHttp = new Intent(actionhttp, uriHttp);
                startActivity(intentHttp);
            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(intentData.length() == 0){
                    Toast.makeText(context,"Please input data.",Toast.LENGTH_SHORT).show();
                }

                String searchData = intentData.getText().toString();
                String actionSearch = Intent.ACTION_WEB_SEARCH;

                Intent intentSearch = new Intent(actionSearch);
                intentSearch.putExtra(SearchManager.QUERY,searchData);
                startActivity(intentSearch);
            }
        });
    }
}
