package com.example.visualizationofsensordata;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Activity20 extends AppCompatActivity implements SensorEventListener {

    private static final String TAG = "activity20";
    private SensorManager sensorManager;
    private Sensor sensors;

    int speed1;

    float tt;
    float hh;
    float cc;

    TextView xValue, yValue, zValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_20);

        speed1 = 2100000000;

        xValue = findViewById(R.id.temp1);
        yValue = findViewById(R.id.hum1);
        zValue = findViewById(R.id.co1);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensors = sensorManager.getDefaultSensor(sensors.TYPE_ACCELEROMETER);
        sensorManager.registerListener(Activity20.this,sensors,speed1);



    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        Log.d(TAG, "onSensorChanged: X:"+ sensorEvent.values[0] + "Y:"+ sensorEvent.values[1]+ "Z:"+ sensorEvent.values[2]);
        tt = (float) Math.round(Math.random()*100)/100.00f + 21.5f;
        xValue.setText("Temperature\n     " + tt + " °C");
        hh = (float) Math.round(Math.random()*99)/100.00f + 69f;
        yValue.setText("Humidity\n " + hh + " %");
        cc = (float) Math.round(Math.random()*500)/100.00f + 530f;
        zValue.setText("       CO2\n" + cc + " ppm");

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}