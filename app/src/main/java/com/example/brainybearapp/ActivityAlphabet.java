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
import com.example.brainybearapp.lists.AlphabetList;

import java.util.ArrayList;

public class ActivityAlphabet extends AppCompatActivity implements RecyclerViewAction {

    RecyclerView recyclerViewAlphabet;
    RecyclerView.Adapter adapter;

    static MediaPlayer mpa;
    static MediaPlayer mpb;
    static MediaPlayer mpc;
    static MediaPlayer mpd;
    static MediaPlayer mpe;
    static MediaPlayer mpf;
    static MediaPlayer mpg;
    static MediaPlayer mph;
    static MediaPlayer mpi;
    static MediaPlayer mpj;
    static MediaPlayer mpk;
    static MediaPlayer mpl;
    static MediaPlayer mpm;
    static MediaPlayer mpn;
    static MediaPlayer mpo;
    static MediaPlayer mpp;
    static MediaPlayer mpq;
    static MediaPlayer mpr;
    static MediaPlayer mps;
    static MediaPlayer mpt;
    static MediaPlayer mpu;
    static MediaPlayer mpv;
    static MediaPlayer mpw;
    static MediaPlayer mpx;
    static MediaPlayer mpy;
    static MediaPlayer mpz;

    ImageView backMenu;
    TextView colorName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_alphabet);

        recyclerViewAlphabet = findViewById(R.id.recycler_alphabet);
        backMenu = findViewById(R.id.menu_nav);

        mpa = MediaPlayer.create(ActivityAlphabet.this, R.raw.a);
        mpb= MediaPlayer.create(ActivityAlphabet.this, R.raw.b);
        mpc= MediaPlayer.create(ActivityAlphabet.this, R.raw.c);
        mpd= MediaPlayer.create(ActivityAlphabet.this, R.raw.d);
        mpe= MediaPlayer.create(ActivityAlphabet.this, R.raw.e);
        mpf= MediaPlayer.create(ActivityAlphabet.this, R.raw.f);
        mpg= MediaPlayer.create(ActivityAlphabet.this, R.raw.g);
        mph= MediaPlayer.create(ActivityAlphabet.this, R.raw.h);
        mpi= MediaPlayer.create(ActivityAlphabet.this, R.raw.i);
        mpj= MediaPlayer.create(ActivityAlphabet.this, R.raw.j);
        mpk= MediaPlayer.create(ActivityAlphabet.this, R.raw.k);
        mpl= MediaPlayer.create(ActivityAlphabet.this, R.raw.l);
        mpm= MediaPlayer.create(ActivityAlphabet.this, R.raw.m);
        mpn= MediaPlayer.create(ActivityAlphabet.this, R.raw.n);
        mpo= MediaPlayer.create(ActivityAlphabet.this, R.raw.o);
        mpp= MediaPlayer.create(ActivityAlphabet.this, R.raw.p);
        mpq= MediaPlayer.create(ActivityAlphabet.this, R.raw.q);
        mpr= MediaPlayer.create(ActivityAlphabet.this, R.raw.r);
        mps= MediaPlayer.create(ActivityAlphabet.this, R.raw.s);
        mpt= MediaPlayer.create(ActivityAlphabet.this, R.raw.t);
        mpu= MediaPlayer.create(ActivityAlphabet.this, R.raw.u);
        mpv= MediaPlayer.create(ActivityAlphabet.this, R.raw.v);
        mpw= MediaPlayer.create(ActivityAlphabet.this, R.raw.w);
        mpx= MediaPlayer.create(ActivityAlphabet.this, R.raw.x);
        mpy= MediaPlayer.create(ActivityAlphabet.this, R.raw.y);
        mpz= MediaPlayer.create(ActivityAlphabet.this, R.raw.z);

        backMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityAlphabet.super.onBackPressed();
            }
        });

        featuredAlphabet();

    }

    private void featuredAlphabet() {
        ArrayList<AlphabetList> questionLocations = new ArrayList<>();
        questionLocations.add(new AlphabetList(R.drawable.apple));
        questionLocations.add(new AlphabetList(R.drawable.ball));
        questionLocations.add(new AlphabetList(R.drawable.cat));
        questionLocations.add(new AlphabetList(R.drawable.dog));
        questionLocations.add(new AlphabetList(R.drawable.elephant));
        questionLocations.add(new AlphabetList(R.drawable.flower));
        questionLocations.add(new AlphabetList(R.drawable.gift));
        questionLocations.add(new AlphabetList(R.drawable.hat));
        questionLocations.add(new AlphabetList(R.drawable.icecream));
        questionLocations.add(new AlphabetList(R.drawable.jug));
        questionLocations.add(new AlphabetList(R.drawable.kite));
        questionLocations.add(new AlphabetList(R.drawable.lion));
        questionLocations.add(new AlphabetList(R.drawable.monkey));
        questionLocations.add(new AlphabetList(R.drawable.ninja));
        questionLocations.add(new AlphabetList(R.drawable.orangecolor));
        questionLocations.add(new AlphabetList(R.drawable.panda));
        questionLocations.add(new AlphabetList(R.drawable.quack));
        questionLocations.add(new AlphabetList(R.drawable.rainbow));
        questionLocations.add(new AlphabetList(R.drawable.snowman));
        questionLocations.add(new AlphabetList(R.drawable.tooth));
        questionLocations.add(new AlphabetList(R.drawable.umbrella));
        questionLocations.add(new AlphabetList(R.drawable.van));
        questionLocations.add(new AlphabetList(R.drawable.watermelon));
        questionLocations.add(new AlphabetList(R.drawable.xray));
        questionLocations.add(new AlphabetList(R.drawable.yoga));
        questionLocations.add(new AlphabetList(R.drawable.zebra));

        adapter = new AlphabetAdapter(questionLocations, this, this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL,  false);
        recyclerViewAlphabet.setLayoutManager(gridLayoutManager);
        recyclerViewAlphabet.setAdapter(adapter);
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
                case 7:
                    mph.start();

                    break;
                case 8:
                    mpi.start();

                    break;
                case 9:
                    mpj.start();

                    break;
                case 10:
                    mpk.start();

                    break;
                case 11:
                    mpl.start();

                    break;
                case 12:
                    mpm.start();

                    break;
                case 13:
                    mpn.start();

                    break;
                case 14:
                    mpo.start();

                    break;
                case 15:
                    mpp.start();

                    break;
                case 16:
                    mpq.start();

                    break;
                case 17:
                    mpr.start();

                    break;
                case 18:
                    mps.start();

                    break;
                case 19:
                    mpt.start();

                    break;
                case 20:
                    mpu.start();

                    break;
                case 21:
                    mpv.start();

                    break;
                case 22:
                    mpw.start();

                    break;
                case 23:
                    mpx.start();

                    break;
                case 24:
                    mpy.start();

                    break;
                case 25:
                    mpz.start();

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
        mph.release();
        mpi.release();
        mpj.release();
        mpk.release();
        mpl.release();
        mpm.release();
        mpn.release();
        mpo.release();
        mpp.release();
        mpq.release();
        mpr.release();
        mps.release();
        mpt.release();
        mpu.release();
        mpv.release();
        mpw.release();
        mpx.release();
        mpy.release();
        mpz.release();

    }
}