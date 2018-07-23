package com.project.choirunnisa.lika;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private ImageView ImgDetailMovie;
    private TextView tvTitleMovie;
    private TextView tvDetailReleaseDate;
    private TextView tvDetailVoteAverage;
    private TextView tvDetailVoteCount;
    private TextView tvDetailOverview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initView();

        Intent intent = getIntent();
        String image = intent.getStringExtra(Config.POSTER_IMAGE);
        String tittle = intent.getStringExtra(Config.TITTLE);
        String overview = intent.getStringExtra(Config.OVERVIEW);
        String release = intent.getStringExtra(Config.RELEASE_DATE);
        String voteCount = intent.getStringExtra(Config.VOTE_COUNT);
        String voteAverage = intent.getStringExtra(Config.VOTE_AVERAGE);
        String popularity = intent.getStringExtra(Config.POPULARITY);


        Picasso.with(this).load(image).error(R.drawable.ic_launcher_background).into(ImgDetailMovie);

        tvTitleMovie.setText(tittle);
        tvDetailReleaseDate.setText(release);
        tvDetailVoteAverage.setText(voteAverage);
        tvDetailVoteCount.setText(voteCount);
        tvDetailOverview.setText(overview);


    }

    private void initView() {
        tvTitleMovie = (TextView) findViewById(R.id.judul);
        ImgDetailMovie = (ImageView) findViewById(R.id.imgposter);
        tvDetailReleaseDate = (TextView) findViewById(R.id.releasedate);
        tvDetailVoteAverage = (TextView) findViewById(R.id.vote_ave);
        tvDetailVoteCount = (TextView) findViewById(R.id.final_rate);
        tvDetailOverview = (TextView) findViewById(R.id.overview);
    }
}

