package com.example.brainybearapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.brainybearapp.Advanced.ActivityAdvancedTest;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AdvancedHomePage extends AppCompatActivity {

    CardView C1, C2, C3;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_home_page);

        C1 = findViewById(R.id.family_card);
        C2 = findViewById(R.id.story_card);
        C3 = findViewById(R.id.test_card);

        floatingActionButton   = (FloatingActionButton) findViewById(R.id.choose_btn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openChoosePath();

            }
        });

        C1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c1();
            }
        });

        C2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c2();
            }
        });

        C3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c3();
            }
        });
    }


    public void c1() {
        Intent intent = new Intent(this, Activity_family.class);
        startActivity(intent);
    }

    public void c2() {
        Intent intent = new Intent(this, storyyyyyy_Test_Activity.class);
        startActivity(intent);
    }

    public void c3() {
        Intent intent = new Intent(this, ActivityAdvancedTest.class);
        startActivity(intent);
    }

    public void openChoosePath(){
        Intent intent = new Intent(this, ChoosePathActivity.class);
        startActivity(intent);
    }

}