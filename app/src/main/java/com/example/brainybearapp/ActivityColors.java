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

import com.example.brainybearapp.adapter.ColorsAdapter;
import com.example.brainybearapp.lists.ColorsList;

import java.util.ArrayList;

public class ActivityColors extends AppCompatActivity implements RecyclerViewAction {

    RecyclerView recyclerViewColors;
    RecyclerView.Adapter adapter;

    static MediaPlayer mpred;
    static MediaPlayer mpyellow;
    static MediaPlayer mpblue;
    static MediaPlayer mpgreen;
    static MediaPlayer mporange;
    static MediaPlayer mppurple;
    static MediaPlayer mpblack;
    static MediaPlayer mpbrown;
    static MediaPlayer mppink;
    static MediaPlayer mpwhite;
    static MediaPlayer mpgrey;


    ImageView backMenu;
    TextView colorName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_colors);

        recyclerViewColors = findViewById(R.id.recycler_color);
        backMenu = findViewById(R.id.menu_nav);

        mpred = MediaPlayer.create(ActivityColors.this, R.raw.red);
        mpyellow= MediaPlayer.create(ActivityColors.this, R.raw.yellow);
        mpblue= MediaPlayer.create(ActivityColors.this, R.raw.blue);
        mpgreen= MediaPlayer.create(ActivityColors.this, R.raw.green);
        mporange= MediaPlayer.create(ActivityColors.this, R.raw.orange);
        mppurple= MediaPlayer.create(ActivityColors.this, R.raw.purple);
        mpblack= MediaPlayer.create(ActivityColors.this, R.raw.black);
        mpbrown= MediaPlayer.create(ActivityColors.this, R.raw.brown);
        mppink= MediaPlayer.create(ActivityColors.this, R.raw.pink);
        mpwhite= MediaPlayer.create(ActivityColors.this, R.raw.white);
        mpgrey= MediaPlayer.create(ActivityColors.this, R.raw.grey);


        backMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityColors.super.onBackPressed();
            }
        });

        featuredAlphabet();

    }

    private void featuredAlphabet() {
        ArrayList<ColorsList> questionLocations = new ArrayList<>();
        questionLocations.add(new ColorsList(R.drawable.red));
        questionLocations.add(new ColorsList(R.drawable.yellow));
        questionLocations.add(new ColorsList(R.drawable.blue));
        questionLocations.add(new ColorsList(R.drawable.green));
        questionLocations.add(new ColorsList(R.drawable.orangecolor));
        questionLocations.add(new ColorsList(R.drawable.purple));
        questionLocations.add(new ColorsList(R.drawable.black));
        questionLocations.add(new ColorsList(R.drawable.brown));
        questionLocations.add(new ColorsList(R.drawable.pink));
        questionLocations.add(new ColorsList(R.drawable.white));
        questionLocations.add(new ColorsList(R.drawable.grey));


        adapter = new ColorsAdapter(questionLocations, this, this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL,  false);
        recyclerViewColors.setLayoutManager(gridLayoutManager);
        recyclerViewColors.setAdapter(adapter);
    }

    @Override
    public void onViewClicked(int clickedViewId, int clickedItemPosition) {
        try {
            switch (clickedItemPosition) {
                case 0:
                    mpred.start();

                    break;
                case 1:
                    mpyellow.start();

                    break;
                case 2:
                    mpblue.start();

                    break;
                case 3:
                    mpgreen.start();

                    break;
                case 4:
                    mporange.start();

                    break;
                case 5:
                    mppurple.start();

                    break;
                case 6:
                    mpblack.start();

                    break;
                case 7:
                    mpbrown.start();

                    break;
                case 8:
                    mppink.start();

                    break;
                case 9:
                    mpwhite.start();

                    break;
                case 10:
                    mpgrey.start();

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
        mpred.release();
        mpyellow.release();
        mpblue.release();
        mpgreen.release();
        mporange.release();
        mppurple.release();
        mpblack.release();
        mpbrown.release();
        mppink.release();
        mpwhite.release();
        mpgrey.release();

    }
}