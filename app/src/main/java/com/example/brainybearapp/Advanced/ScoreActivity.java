package com.example.brainybearapp.Advanced;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.brainybearapp.R;

public class ScoreActivity extends AppCompatActivity {
    TextView nm,correct,incorrect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Bundle b=getIntent().getExtras();
        String name = b.getString("uname");
        int Correct = b.getInt("correct");
        int wrong = b.getInt("wrong");
        //System.out.println(correc+"      "+wrong+"    "+name);

        nm= findViewById(R.id.view);
        correct = findViewById(R.id.Correct);
        incorrect =findViewById(R.id.wron);

        nm.setText(name +" Your Score Is");
        correct.setText("Correct : "+Correct);
        incorrect.setText("Incorrect : "+wrong);


    }

    public void restart(View view) {
        Intent i = new Intent(getApplicationContext(),ActivityAdvancedTest.class);

        nm.setText(" ");
        correct.setText(" ");
        incorrect.setText(" ");

        startActivity(i);
    }
}