 package com.example.brainybearapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

 public class dashBoard extends AppCompatActivity {
     private  Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dash_board);

        button = (Button) findViewById(R.id.SignUpbtn);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChoosePathActivity();

            }
        });

    }

    public void openChoosePathActivity(){
        Intent intent = new Intent(this, ChoosePathActivity.class);
        startActivity(intent);
    }

}