package com.corbishley.intentcamera;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.File;

public class MainActivity extends Activity {

    private static final String TAG = "main";
    private static final int IntentRequestCode = 100;
    private Context context;
    private ImageButton cameraButton;
    private ImageView picture;
    private String storagepath;
    private File file;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        cameraButton = (ImageButton) findViewById(R.id.imageButton_camera);
        picture = (ImageView) findViewById(R.id.imageView_pic);
        picture.setVisibility(View.INVISIBLE);

        //storagepath = getFilesDir().getAbsolutePath();                  //*****************
        storagepath = getExternalFilesDir(null).getAbsolutePath();   //*****************
        Log.d(TAG,"storagepath ="+storagepath);
        file = new File(storagepath+"/"+"photo1.png");
        Log.d(TAG,"file ="+file);

        uri = FileProvider.getUriForFile(context,BuildConfig.APPLICATION_ID+".provider",file);
        Log.d(TAG,"uri ="+uri);

        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                picture.setVisibility(View.INVISIBLE);
                picture.setImageResource(R.drawable.stock_lock);

                String action = MediaStore.ACTION_IMAGE_CAPTURE;
                Intent intent = new Intent(action);

                intent.putExtra(MediaStore.EXTRA_OUTPUT,uri);
                startActivityForResult(intent, IntentRequestCode);
            }
        });
    } // end of on Create()

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        picture.setVisibility(View.VISIBLE);

        if(requestCode == IntentRequestCode && resultCode == Activity.RESULT_OK){

            Uri imageUri = Uri.parse(file.getAbsolutePath());
            Log.d(TAG,"imageuri ="+imageUri);

            picture.setImageURI(imageUri);

        }
    }
}
