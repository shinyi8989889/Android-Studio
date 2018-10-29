package com.corbishley.sensorcontrol;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ACCActivity extends Activity {

    private Context context;
    private TextView textViewACC;
    private ImageView imageViewTop,imageViewDown,imageViewLeft,imageViewRight;
    private ImageButton imageButtonStop;
    private SensorManager sensorManager;
    private Sensor sensor;
    private MyListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acc);

        context = this;
        setTitle("ACC Sensor");

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        textViewACC = (TextView)findViewById(R.id.textView_acc);
        textViewACC.setText("");

        imageViewTop = (ImageView) findViewById(R.id.imageView_top);
        imageViewDown = (ImageView) findViewById(R.id.imageView_down);
        imageViewLeft = (ImageView) findViewById(R.id.imageView_left);
        imageViewRight = (ImageView) findViewById(R.id.imageView_right);
        imageViewTop.setVisibility(View.INVISIBLE);
        imageViewLeft.setVisibility(View.INVISIBLE);
        imageViewRight.setVisibility(View.INVISIBLE);
        imageViewDown.setVisibility(View.INVISIBLE);

        imageButtonStop = (ImageButton) findViewById(R.id.imageButton_stop);
        imageButtonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Stop Button",Toast.LENGTH_SHORT).show();
            }
        });
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        listener = new MyListener();
        sensorManager.registerListener(listener,sensor,SensorManager.SENSOR_DELAY_UI);
    }

    private class MyListener implements SensorEventListener {
        @Override
        public void onSensorChanged(SensorEvent event) {
            StringBuilder sb = new StringBuilder();
            sb.append("sensor : "+event.sensor.getName()+"\n");
            sb.append("values:\n");

            float X_value = event.values[0];
            float Y_value = event.values[1];
            float Z_value = event.values[2];  //float是資料型態 Float是物件

            sb.append("X = "+Float.toString(X_value)+"\n");
            sb.append("Y = "+Float.toString(Y_value)+"\n");
            sb.append("Z = "+Float.toString(Z_value)+"\n");

            textViewACC.setText(sb.toString());

            if (X_value < -2.0){  //turn right

                imageViewTop.setVisibility(View.INVISIBLE);
                imageViewLeft.setVisibility(View.INVISIBLE);
                imageViewRight.setVisibility(View.VISIBLE);
                imageViewDown.setVisibility(View.INVISIBLE);

            }else if(X_value >2.0){  //turn left

                imageViewTop.setVisibility(View.INVISIBLE);
                imageViewLeft.setVisibility(View.VISIBLE);
                imageViewRight.setVisibility(View.INVISIBLE);
                imageViewDown.setVisibility(View.INVISIBLE);

            }else {

                if (Z_value > 5){  //代表往前走

                    imageViewTop.setVisibility(View.VISIBLE);
                    imageViewLeft.setVisibility(View.INVISIBLE);
                    imageViewRight.setVisibility(View.INVISIBLE);
                    imageViewDown.setVisibility(View.INVISIBLE);

                }else if (Z_value < 0 ){  //向後走

                    imageViewTop.setVisibility(View.INVISIBLE);
                    imageViewLeft.setVisibility(View.INVISIBLE);
                    imageViewRight.setVisibility(View.INVISIBLE);
                    imageViewDown.setVisibility(View.VISIBLE);

                }else{   //不動的,不改變,不會改變行進方向

                    imageViewTop.setVisibility(View.INVISIBLE);
                    imageViewLeft.setVisibility(View.INVISIBLE);
                    imageViewRight.setVisibility(View.INVISIBLE);
                    imageViewDown.setVisibility(View.INVISIBLE);

                }
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    }

    @Override
    protected void onDestroy() {
        sensorManager.unregisterListener(listener);
        super.onDestroy();
    }
}

