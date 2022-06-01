package com.example.brainybearapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityNumbers extends AppCompatActivity implements View.OnClickListener {

    ViewFlipper viewFlipper;
    Button next, previous;
    int i =0;

    static MediaPlayer mp1;
    static MediaPlayer mp2;
    static MediaPlayer mp;
    static MediaPlayer mpfour;
    static MediaPlayer mpfive;
    static MediaPlayer mpsix;
    static MediaPlayer mpseven;
    static MediaPlayer mpeight;
    static MediaPlayer mpnine;
    static MediaPlayer mpten;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_numbers);

        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        next = (Button) findViewById(R.id.Next);
        previous = (Button) findViewById(R.id.Previous);

        next.setOnClickListener(this);
        previous.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == next) {
            viewFlipper.showNext();
        } else if (v == previous) {
            viewFlipper.showPrevious();

        }

    }
}