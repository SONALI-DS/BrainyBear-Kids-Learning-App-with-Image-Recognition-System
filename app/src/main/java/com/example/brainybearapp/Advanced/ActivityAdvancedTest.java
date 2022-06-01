package com.example.brainybearapp.Advanced;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.brainybearapp.R;


public class ActivityAdvancedTest extends AppCompatActivity {

    TextView name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_test);

    }

    public void startQuiz(View view) {
        name = findViewById(R.id.name);
        String nam= name.getText().toString();
        Intent intent=new Intent(getApplicationContext(),ActivityAdvancedGame.class);
        intent.putExtra("name",nam);
        startActivity(intent);
    }
}