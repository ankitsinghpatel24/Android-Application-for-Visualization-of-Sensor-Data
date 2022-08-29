package com.example.visualizationofsensordata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Activity4 extends AppCompatActivity {

    private ImageButton t2;

    private ImageButton h2;

    private ImageButton c2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        t2 = (ImageButton) findViewById(R.id.t2);
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity9();
            }
        });

        h2 = (ImageButton) findViewById(R.id.h2);
        h2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity10();
            }
        });

        c2 = (ImageButton) findViewById(R.id.c2);
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity11();
            }
        });


    }

    public void openActivity9() {
        Intent intent = new Intent(this, Activity9.class);
        startActivity(intent);
    }

    public void openActivity10() {
        Intent intent = new Intent(this, Activity10.class);
        startActivity(intent);
    }

    public void openActivity11() {
        Intent intent = new Intent(this, Activity11.class);
        startActivity(intent);

    }

}