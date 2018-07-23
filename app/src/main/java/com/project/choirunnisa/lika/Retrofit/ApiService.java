package com.project.choirunnisa.lika.Retrofit;
import com.project.choirunnisa.lika.Model.MovieModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Nisa on 02/06/2018.
 */

public interface ApiService {
    @GET("movie?api_key=0811d90b0421880f4255073482eca800&language=en-US")
    Call<MovieModel>getMovie(@Query("query") String query);
}


