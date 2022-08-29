package com.example.visualizationofsensordata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Activity5 extends AppCompatActivity {

    private ImageButton t3;

    private ImageButton h3;

    private ImageButton c3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);

        t3 = (ImageButton) findViewById(R.id.t3);
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity12();
            }
        });

        h3 = (ImageButton) findViewById(R.id.h3);
        h3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity13();
            }
        });

        c3 = (ImageButton) findViewById(R.id.c3);
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity14();
            }
        });


    }

    public void openActivity12() {
        Intent intent = new Intent(this, Activity12.class);
        startActivity(intent);
    }

    public void openActivity13() {
        Intent intent = new Intent(this, Activity13.class);
        startActivity(intent);
    }

    public void openActivity14() {
        Intent intent = new Intent(this, Activity14.class);
        startActivity(intent);

    }

}