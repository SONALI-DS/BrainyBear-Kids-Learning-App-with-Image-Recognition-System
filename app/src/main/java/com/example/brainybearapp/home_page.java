package com.example.brainybearapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.brainybearapp.imageRecognition.imageRecog;
import com.example.brainybearapp.paint.ActivityPaint;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class home_page extends AppCompatActivity {
//    variables
    CardView BAnimals, BAlphabet, BNumbers, BColors, BShapes, BPaint, BTest;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home_page);

        BAnimals = findViewById(R.id.BAnimals);
        BAlphabet = findViewById(R.id.BAlphabet);
        BNumbers = findViewById(R.id.BNumbers);
        BColors = findViewById(R.id.BColors);
        BShapes = findViewById(R.id.BShapes);
        BPaint = findViewById(R.id.BPaint);
        BTest = findViewById(R.id.BTest);

        floatingActionButton   = (FloatingActionButton) findViewById(R.id.choose_btn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openChoosePath();

            }
        });

        BAnimals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                banimal();
            }
        });

        BAlphabet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bAlphabet();
            }
        });

        BNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bNumbers();
            }
        });

        BColors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bColors();
            }
        });

        BShapes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bShapes();
            }
        });

        BPaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bPaint();
            }
        });

        BTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bTest();
            }
        });

    }


    public void banimal(){
        Intent intent = new Intent(this, imageRecog.class);
        startActivity(intent);
    }

    public void bAlphabet(){
        Intent intent = new Intent(this, ActivityAlphabet.class);
        startActivity(intent);
    }
    public void bNumbers(){
        Intent intent = new Intent(this, ActivityNumbers.class);
        startActivity(intent);
    }
    public void bColors(){
        Intent intent = new Intent(this, ActivityColors.class);
        startActivity(intent);
    }
    public void bShapes(){
        Intent intent = new Intent(this, ActivityShapes.class);
        startActivity(intent);
    }
    public void bPaint(){
        Intent intent = new Intent(this, ActivityPaint.class);
        startActivity(intent);
    }
    public void bTest(){
        Intent intent = new Intent(this, ActivityTest.class);
        startActivity(intent);
    }

    public void openChoosePath(){
        Intent intent = new Intent(this, ChoosePathActivity.class);
        startActivity(intent);
    }
}