package com.example.visualizationofsensordata;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Activity21 extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_21);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewpager);

        tabLayout.setupWithViewPager(viewPager);

        VPAdapter vpAdapter = new VPAdapter(getSupportFragmentManager());
        vpAdapter.addFragment(new Fragment1(),"Node 1");
        vpAdapter.addFragment(new Fragment2(),"Node 2");
        vpAdapter.addFragment(new Fragment3(),"Node 3");
        viewPager.setAdapter(vpAdapter);
    }
}