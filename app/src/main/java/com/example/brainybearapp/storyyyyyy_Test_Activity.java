package com.example.brainybearapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class storyyyyyy_Test_Activity extends AppCompatActivity {



    private FloatingActionButton floatingActionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storyyyyyy_test);

        floatingActionButton   = (FloatingActionButton) findViewById(R.id.home_btn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openAdvancedHomePage();

            }
        });

    }

    public void openAdvancedHomePage(){
        Intent intent = new Intent(this, AdvancedHomePage.class);
        startActivity(intent);
    }

}