package com.example.brainybearapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.brainybearapp.adapter.FamilyAdapter;
import com.example.brainybearapp.lists.FamilyList;

import java.util.ArrayList;

public class Activity_family extends AppCompatActivity implements RecyclerViewAction {

    RecyclerView recyclerViewFamily;
    RecyclerView.Adapter adapter;

    static MediaPlayer mpa;
    static MediaPlayer mpb;
    static MediaPlayer mpc;
    static MediaPlayer mpd;
    static MediaPlayer mpe;
    static MediaPlayer mpf;
    static MediaPlayer mpg;


    ImageView backMenu;
    TextView colorName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_family);

        recyclerViewFamily = findViewById(R.id.recycler_family);
        backMenu = findViewById(R.id.menu_nav);

        mpa = MediaPlayer.create(Activity_family.this, R.raw.a);
        mpb= MediaPlayer.create(Activity_family.this, R.raw.b);
        mpc= MediaPlayer.create(Activity_family.this, R.raw.c);
        mpd= MediaPlayer.create(Activity_family.this, R.raw.d);
        mpe= MediaPlayer.create(Activity_family.this, R.raw.e);
        mpf= MediaPlayer.create(Activity_family.this, R.raw.f);
        mpg= MediaPlayer.create(Activity_family.this, R.raw.g);


        backMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity_family.super.onBackPressed();
            }
        });

        featuredFamily();

    }

    private void featuredFamily() {
        ArrayList<FamilyList> questionLocations = new ArrayList<>();
        questionLocations.add(new FamilyList(R.drawable.mother));
        questionLocations.add(new FamilyList(R.drawable.father));
        questionLocations.add(new FamilyList(R.drawable.sister));
        questionLocations.add(new FamilyList(R.drawable.brother));
        questionLocations.add(new FamilyList(R.drawable.baby));
        questionLocations.add(new FamilyList(R.drawable.grandmother));
        questionLocations.add(new FamilyList(R.drawable.grandmother));

        adapter = new FamilyAdapter(questionLocations, this, this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1, GridLayoutManager.HORIZONTAL,  false);
        recyclerViewFamily.setLayoutManager(gridLayoutManager);
        recyclerViewFamily.setAdapter(adapter);
    }

    @Override
    public void onViewClicked(int clickedViewId, int clickedItemPosition) {
        try {
            switch (clickedItemPosition) {
                case 0:
                    mpa.start();

                    break;
                case 1:
                    mpb.start();

                    break;
                case 2:
                    mpc.start();

                    break;
                case 3:
                    mpd.start();

                    break;
                case 4:
                    mpe.start();

                    break;
                case 5:
                    mpf.start();

                    break;
                case 6:
                    mpg.start();

                    break;


                default:
                    Toast.makeText(this, "Wrong index", Toast.LENGTH_SHORT).show();
                    colorName.setText("alphabet");
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onViewLongClicked(int clickedViewId, int clickedItemPosition) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mpa.release();
        mpb.release();
        mpc.release();
        mpd.release();
        mpe.release();
        mpf.release();
        mpg.release();


    }

}