package com.example.visualizationofsensordata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Activity18 extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_18);

        textView = findViewById(R.id.textView);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE,  dd-MMM-yyyy,  hh:mm:ss a");
        String dateTime = simpleDateFormat.format(calendar.getTime());
        textView.setText(dateTime);
    }
}