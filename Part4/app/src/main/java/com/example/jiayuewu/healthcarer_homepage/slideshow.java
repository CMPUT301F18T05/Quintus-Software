package com.example.jiayuewu.healthcarer_homepage;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class slideshow extends AppCompatActivity {

    // slideshow learned from https://www.youtube.com/watch?v=Q2FPDI99-as
    // and https://stackoverflow.com/questions/17610085/how-to-switch-automatically-between-viewpager-pages
    private Handler handler;
    private ViewPager viewPager;
    private ImageAdapter adapter;
    private ImageView imageView;
    private int delay = 2500; //milliseconds
    private int page = 0;
    Runnable runnable = new Runnable() {
        public void run() {
            if (adapter.getCount() == page) {
                page = 0;
            } else {
                page++;
            }
            viewPager.setCurrentItem(page, true);
            handler.postDelayed(this, delay);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slideshow);
        handler = new Handler();
        FloatingActionButton play = findViewById(R.id.slideshow_play);
        FloatingActionButton stop = findViewById(R.id.slideshow_stop);
        viewPager = findViewById(R.id.slideshow_viewpager);

        Bitmap[] lists = trialGetPhotoList();

        adapter = new ImageAdapter(this, lists);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                page = i;
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        onPause();

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onResume();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPause();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(runnable, delay);
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }

    private Bitmap[] trialGetPhotoList() {
        Bitmap[] listOfPhotoes = new Bitmap[2];

        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.body_front);
        Bitmap bm1  = BitmapFactory.decodeResource(getResources(), R.drawable.body_back);

        listOfPhotoes[0] = bm;
        listOfPhotoes[1] = bm1;

        return listOfPhotoes;
    }
}
