package com.project.choirunnisa.lika.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.choirunnisa.lika.Config;
import com.project.choirunnisa.lika.DetailActivity;
import com.project.choirunnisa.lika.Model.ResultMovie;
import com.project.choirunnisa.lika.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Nisa on 20/07/2018.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {
    private Context context;
    //TODO 1
    private ArrayList<ResultMovie> listPopuler;

    //TODO 2
    public MovieAdapter(Context context, ArrayList<ResultMovie> listPopuler) {
        this.context = context;
        this.listPopuler = listPopuler;
    }

    @Override
    public MovieAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_movie,
                parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MovieAdapter.MyViewHolder holder, final int position) {
        //TODO 3
//
        holder.tvJudulFilm.setText(listPopuler.get(position).getTitle());
        holder.tvoverview.setText(listPopuler.get(position).getOverview());
        holder.tvrelease.setText(listPopuler.get(position).getReleaseDate());

        Picasso.with(context)
                .load("https://image.tmdb.org/t/p/w500" + listPopuler.get(position).getPosterPath())
                .into(holder.ImgFilm);

        holder.cv_klick_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(Config.POSTER_IMAGE, "https://image.tmdb.org/t/p/w500" +listPopuler.get(position).getPosterPath());
                intent.putExtra(Config.TITTLE, holder.tvJudulFilm.getText().toString().trim());
                intent.putExtra(Config.OVERVIEW, listPopuler.get(position).getOverview());
                intent.putExtra(Config.RELEASE_DATE, holder.tvrelease.getText().toString().trim());

                intent.putExtra(Config.VOTE_COUNT, listPopuler.get(position).getVoteCount());
                intent.putExtra(Config.VOTE_AVERAGE, listPopuler.get(position).getVoteAverage());
                intent.putExtra(Config.POPULARITY, listPopuler.get(position).getPopularity());
                context.startActivity(intent);
            }
        });
    }

    //TODO 4
    @Override
    public int getItemCount() {
        return listPopuler.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ImgFilm;
        TextView tvJudulFilm;
        TextView tvoverview;
        TextView tvrelease;
        CardView cv_klick_detail;

        public MyViewHolder(View itemView) {
            super(itemView);

            ImgFilm = itemView.findViewById(R.id.img_poster);
            tvJudulFilm = itemView.findViewById(R.id.tv_tittle);
            tvoverview = itemView.findViewById(R.id.tv_overview);
            tvrelease = itemView.findViewById(R.id.tv_release);
            cv_klick_detail = itemView.findViewById(R.id.cv_detail);
        }
    }}




