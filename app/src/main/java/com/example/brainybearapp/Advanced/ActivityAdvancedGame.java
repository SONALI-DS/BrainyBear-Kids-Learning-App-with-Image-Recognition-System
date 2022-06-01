package com.example.brainybearapp.Advanced;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.brainybearapp.R;

public class ActivityAdvancedGame extends AppCompatActivity {
    TextView corr,wro,que;
    RadioButton r1,r2,r3,r4;
    int flag=0;
    public static int correct=0,wrong=0;
    String name;

    String questions[] = {

            "How many colours are there in a rainbow ?",
            "250+124-(2*4) = ?",
            "Who is the ship of the desert ?",
            "How many letters are there in the English alphabet ?",
            "How many legs does a spider have ?",
            "Which are the vowels in the English alphabet series?",
    };
    String answers[] = {"07 colours","366","The Camel","26 Letters","6","A, E, I, O, U"};

    String opt[] = {
            "05 colours","07 colours","08 colours","10 colours",
            "366","300","299","100",
            "The Camel","The Horse","The cat","The Dolphin",
            "24 Letters","22 Letters","25 Letters","26 Letters",
            "5","6","8","12",
            "A, E, I, U","A, E, I, O, U","A, B, C, D","X, Y, I, O, U",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_game);

        corr = findViewById(R.id.right);
        wro = findViewById(R.id.wrong);
        que = findViewById(R.id.que);

        r1=findViewById(R.id.opt1);
        r2=findViewById(R.id.opt2);
        r3=findViewById(R.id.opt3);
        r4=findViewById(R.id.opt4);

        que.setText(questions[flag]);
        r1.setText(opt[flag *4]);
        r2.setText(opt[flag *4 +1]);
        r3.setText(opt[flag *4 +2]);
        r4.setText(opt[flag *4 +3]);

    }


    public void checkAns(View view) {

        RadioGroup rg = (RadioGroup) findViewById(R.id.grp);
        final String selected =
                ((RadioButton)findViewById(rg.getCheckedRadioButtonId()))
                        .getText().toString();
        rg.clearCheck();
        if(selected.equals(answers[flag])){
            flag++;
            correct++;
        }
        else{
            flag++;
            wrong++;
        }
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {updateQuestion();}
        }, 1200);
    }
    void updateQuestion() {

        if(flag!=5){
            corr.setText(""+correct);
            wro.setText(""+wrong);
            que.setText(questions[flag]);
            r1.setText(opt[flag *4]);
            r2.setText(opt[flag *4 +1]);
            r3.setText(opt[flag *4 +2]);
            r4.setText(opt[flag *4 +3]);
        }
        else{
            Intent i = new Intent(getApplicationContext(),ScoreActivity.class);
            Bundle bb = new Bundle();
            bb.putInt("correct",correct);
            bb.putInt("wrong",wrong);

            Intent prev = getIntent();
            String name = prev.getStringExtra("name");
            bb.putString("uname",name);
            i.putExtras(bb);
            startActivity(i);
            correct=0;
            wrong=0;
        }
    }
}