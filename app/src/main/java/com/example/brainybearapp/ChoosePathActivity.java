package com.example.brainybearapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class ChoosePathActivity extends AppCompatActivity  {
//   private FloatingActionButton floatingActionButton;
    CardView card1 , card2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_choose_path);

//        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        card1 =  findViewById(R.id.BeginnerCardView);
        card2 =  findViewById(R.id.AdvancedCardView);

//        floatingActionButton.setOnClickListener(this);
//        card1.setOnClickListener(this);
//        card2.setOnClickListener(this);

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChoosePathActivity();

            }
        });

        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                advHomePage();
            }
        });

    }
//            @Override
//            public void onClick(View v) {
//        Intent i;
//
//        switch (v.getId()){
//            case R.id.biginerCardView:
//                i = new Intent(this,home_page.class);
//                startActivity(i);
//                break;
//
//            case R.id.AdvancedCardView:
//                i = new Intent(this, AdvancedHomePage.class);
//
//        }
//            }



    public void openChoosePathActivity(){
        Intent intent = new Intent(this, home_page.class);
        startActivity(intent);
    }

    public void advHomePage(){
        Intent intent = new Intent(this, AdvancedHomePage.class);
        startActivity(intent);
    }
}


//        card1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openhome_page();
//            }
//        });
//
//    }
//
//        public void opendashBoard(){
//            Intent intent = new Intent(this, dashBoard.class);
//            startActivity(intent);
//
//    }
//
//    public void openhome_page() {
//        Intent intent = new Intent(this, home_page.class);
//        startActivity(intent);
//    }
//
//    @Override
//    public void onClick(View v) {
//
//    }
//}
