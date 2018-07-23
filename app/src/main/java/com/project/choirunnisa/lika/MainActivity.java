package com.project.choirunnisa.lika;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.util.SortedList;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.project.choirunnisa.lika.Adapter.MovieAdapter;
import com.project.choirunnisa.lika.Model.MovieModel;
import com.project.choirunnisa.lika.Model.ResultMovie;
import com.project.choirunnisa.lika.Retrofit.ApiService;
import com.project.choirunnisa.lika.Retrofit.Client;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText editMovie;
    private Button btnCari;
    private RecyclerView rv;
    private ArrayList<ResultMovie> listMovie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        listMovie = new ArrayList<>();

        btnCari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, Config.PROGRESS_LOAD, Toast.LENGTH_SHORT).show();
                getMovie();
            }
        });
    }
    private void getMovie() {
        ApiService apiService = Client.getInstanceRetrofit();
        apiService.getMovie(editMovie.getText().toString().trim())
                .enqueue(new Callback<MovieModel>() {
                    @Override
                    public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                        if (response.isSuccessful()) {
                            listMovie = response.body().getResults();
                            MovieAdapter adapter = new MovieAdapter(MainActivity.this, listMovie);
                            rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                            rv.setAdapter(adapter);
                            Toast.makeText(MainActivity.this, "Sucsess", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(MainActivity.this, Config.ERROR_LIST, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<MovieModel> call, Throwable t) {
                        Toast.makeText(MainActivity.this, Config.ERROR_NETWORK, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void initView() {
        editMovie = (EditText) findViewById(R.id.edit_judul);
        btnCari = (Button) findViewById(R.id.btn_search);
        rv = (RecyclerView) findViewById(R.id.rv);
    }
}



