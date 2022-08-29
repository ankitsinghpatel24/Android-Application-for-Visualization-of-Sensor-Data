package com.example.visualizationofsensordata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class Activity22 extends AppCompatActivity {

    RatingBar ratingBar;

    Button btsubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_22);

        ratingBar = findViewById(R.id.rating_bar);

        btsubmit = findViewById(R.id.bt_submit);

        btsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = String.valueOf(ratingBar.getRating());
                Toast.makeText(Activity22.this, s+" Star", Toast.LENGTH_SHORT).show();
            }
        });

    }
}