package com.corbishley.intentappget;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class playVideoActivity extends Activity {

    private static final String TAG = "video";
    private Context context;
    private TextView textViewVideo;
    private VideoView videoView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);

        context = this;
        setTitle("Play Video");

        textViewVideo = (TextView) findViewById(R.id.textView_video);

        videoView1 = (VideoView) findViewById(R.id.videoView_id);
        String path = "android.resource://"+getPackageName()+"/"+R.raw.cartoon1;
        textViewVideo.setText("Play Video: \n");
        textViewVideo.append(path);

        Log.d(TAG,"path = "+path);

        Uri uri = Uri.parse(path);
        Log.d(TAG,"uri = "+uri);

        MediaController controller = new MediaController(context);

        videoView1.setVideoPath(path);
  //      videoView1.setVideoURI(uri);
        videoView1.setMediaController(controller);
    }
}
