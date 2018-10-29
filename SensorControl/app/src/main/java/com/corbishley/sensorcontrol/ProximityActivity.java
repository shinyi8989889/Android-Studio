package com.corbishley.sensorcontrol;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProximityActivity extends Activity {

    private Context context;
    private TextView textViewProx;
    private ImageView imageViewGirl;
    private SensorManager sensorManager;
    private MyListener listenser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity);

        setTitle("Proximity Sensor");
        context = this;

        textViewProx = (TextView) findViewById(R.id.textView_proxid);
        imageViewGirl = (ImageView) findViewById(R.id.imageView_girl);
        textViewProx.setText("");

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        listenser = new MyListener();
        sensorManager.registerListener(listenser,sensor,SensorManager.SENSOR_DELAY_FASTEST);

    }

    private class MyListener implements SensorEventListener {

        @Override
        public void onSensorChanged(SensorEvent event) { //真正要的,監聽數值的改變
            StringBuilder sb = new StringBuilder();
            sb.append("Sensor : " +event.sensor.getName()+"\n");
            float proxValue = event.values[0];
            sb.append("Proximity value : "+proxValue + "cm\n");

            if (proxValue < 1 ){
                textViewProx.setText(sb.toString()+"Go away!!!!!");
                imageViewGirl.setImageResource(R.drawable.p2);
            }else{
                textViewProx.setText(sb.toString());
                imageViewGirl.setImageResource(R.drawable.p1);
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    }

    @Override
    protected void onDestroy() { //要關掉它
        sensorManager.unregisterListener(listenser);
        super.onDestroy();
    }
}
