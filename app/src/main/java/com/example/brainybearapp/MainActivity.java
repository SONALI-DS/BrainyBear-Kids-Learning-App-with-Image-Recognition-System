package com.example.brainybearapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView splashImage,img2;
    Animation bottom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

//        splashImage=(ImageView)findViewById(R.id.img);
        img2=(ImageView)findViewById(R.id.subLogo);

//        splashImage.animate().translationY(-2200).setDuration(1000).setStartDelay(4000);
//        img2.animate().translationY(1400).setDuration(1000).setStartDelay(4000);

        bottom= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.sublogoanimation);

        img2.setAnimation(bottom);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(getApplicationContext(),dashBoard.class));

            }
        }, 5000);

    }
}