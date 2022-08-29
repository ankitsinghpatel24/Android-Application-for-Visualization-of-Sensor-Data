package com.example.visualizationofsensordata;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActivityHome extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private Button nodes;

    private Button ins;

    private Button contacts;

    private Button about;

    private Button settings;

    private Button location;

    private Button eta;

    private Button share;

    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //getSupportActionBar().hide();

        nodes = (Button) findViewById(R.id.nodes);
        nodes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity21();
            }
        });

        ins = (Button) findViewById(R.id.ins);
        ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity20();
            }
        });

        contacts = (Button) findViewById(R.id.contacts);
        contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });

        about = (Button) findViewById(R.id.about);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityHelp();
            }
        });

        settings = (Button) findViewById(R.id.settings);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensettings();
            }
        });

        location = (Button) findViewById(R.id.location);
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity17();
            }
        });

        eta = (Button) findViewById(R.id.eta);
        eta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity18();
            }
        });

        share = (Button) findViewById(R.id.share);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String Body = "Download this App";
                String Sub = "http://play.google.com";
                intent.putExtra(Intent.EXTRA_TEXT, Body);
                intent.putExtra(Intent.EXTRA_TEXT, Sub);
                startActivity(Intent.createChooser(intent, "Share using"));
            }
        });

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        navigationView.bringToFront();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.nav_home);


    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


        public void openActivity21 () {
            Intent intent = new Intent(this, Activity21.class);
            startActivity(intent);
        }

        public void openActivity20 () {
            Intent intent = new Intent(this, Activity20.class);
            startActivity(intent);
        }

        public void openActivity2 () {
            Intent intent = new Intent(this, Activity2.class);
            startActivity(intent);
        }


        public void openActivityHelp () {
            Intent intent = new Intent(this, ActivityHelp.class);
            startActivity(intent);
        }

        public void opensettings() {
            Intent intent = new Intent(this, settings.class);
            startActivity(intent);
        }

        public void openActivity17 () {
            Intent intent = new Intent(this, Activity17.class);
            startActivity(intent);
        }
    public void openActivity18 () {
        Intent intent = new Intent(this, Activity18.class);
        startActivity(intent);

        }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                Intent intent3 = new Intent(this, ActivityHome.class);
                startActivity(intent3);
                break;

            case R.id.nav_settings:
                Intent intent = new Intent(this, settings.class);
                startActivity(intent);
                break;

            case R.id.nav_share:
                Toast.makeText(this,"Share", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(Intent.ACTION_SEND);
                intent1.setType("text/plain");
                String Body = "Download this App";
                String Sub = "http://play.google.com";
                intent1.putExtra(Intent.EXTRA_TEXT, Body);
                intent1.putExtra(Intent.EXTRA_TEXT, Sub);
                startActivity(Intent.createChooser(intent1, "Share using"));;
                break;

            case R.id.nav_ratings:
                Toast.makeText(this,"Rate us between 0-5", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(this, Activity22.class);
                startActivity(intent2);
                break;

        }
        return true;
    }
}
