package com.example.brainybearapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.brainybearapp.adapter.AlphabetAdapter;
import com.example.brainybearapp.adapter.ShapeAdapter;
import com.example.brainybearapp.lists.ShapesList;

import java.util.ArrayList;

public class ActivityShapes extends AppCompatActivity implements RecyclerViewAction {

    RecyclerView recyclerViewShape;
    RecyclerView.Adapter adapter;

    static MediaPlayer mpone;
    static MediaPlayer mptwo;
    static MediaPlayer mpthree;
    static MediaPlayer mpfour;
    static MediaPlayer mpfive;
    static MediaPlayer mpsix;
    static MediaPlayer mpseven;
    static MediaPlayer mpeight;

    ImageView backMenu;
    TextView colorName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_shapes);

        recyclerViewShape = findViewById(R.id.recycler_shape);
        backMenu = findViewById(R.id.menu_nav);


        mpone = MediaPlayer.create(ActivityShapes.this, R.raw.circle);
        mptwo = MediaPlayer.create(ActivityShapes.this, R.raw.square);
        mpthree = MediaPlayer.create(ActivityShapes.this, R.raw.triangle);
        mpfour = MediaPlayer.create(ActivityShapes.this, R.raw.star);
        mpfive = MediaPlayer.create(ActivityShapes.this, R.raw.rectangle);
        mpsix = MediaPlayer.create(ActivityShapes.this, R.raw.oval);
        mpseven = MediaPlayer.create(ActivityShapes.this, R.raw.pentagon);
        mpeight = MediaPlayer.create(ActivityShapes.this, R.raw.hexagon);

        backMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityShapes.super.onBackPressed();
            }
        });

        featuredShapes();

    }

    private void featuredShapes() {
        ArrayList<ShapesList> questionLocations = new ArrayList<>();
        questionLocations.add(new ShapesList(R.drawable.circle));
        questionLocations.add(new ShapesList(R.drawable.square));
        questionLocations.add(new ShapesList(R.drawable.triangle));
        questionLocations.add(new ShapesList(R.drawable.star));
        questionLocations.add(new ShapesList(R.drawable.rectangle));
        questionLocations.add(new ShapesList(R.drawable.oval));
        questionLocations.add(new ShapesList(R.drawable.pentagon));
        questionLocations.add(new ShapesList(R.drawable.hexagon));

        adapter = new ShapeAdapter(questionLocations, this, this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1, GridLayoutManager.HORIZONTAL, false);
        recyclerViewShape.setLayoutManager(gridLayoutManager);
        recyclerViewShape.setAdapter(adapter);
    }

    @Override
    public void onViewClicked(int clickedViewId, int clickedItemPosition) {
        try {
            switch (clickedItemPosition) {
                case 0:
                    mpone.start();

                    break;
                case 1:
                    mptwo.start();

                    break;
                case 2:
                    mpthree.start();

                    break;
                case 3:
                    mpfour.start();

                    break;
                case 4:
                    mpfive.start();

                    break;
                case 5:
                    mpsix.start();

                    break;
                case 6:
                    mpseven.start();

                    break;
                case 7:
                    mpeight.start();

                    break;
                default:
                    Toast.makeText(this, "Wrong index", Toast.LENGTH_SHORT).show();
                    colorName.setText("Shapes");
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
        mpone.release();
        mptwo.release();
        mpthree.release();
        mpfour.release();
        mpfive.release();
        mpsix.release();
        mpseven.release();
        mpeight.release();
    }
}