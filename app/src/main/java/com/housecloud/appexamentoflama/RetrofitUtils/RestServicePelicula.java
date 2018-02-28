package com.housecloud.appexamentoflama.RetrofitUtils;

import com.housecloud.appexamentoflama.Model.Peliculas;

import java.lang.reflect.Array;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 21642432 on 28/02/2018.
 */

public interface RestServicePelicula {

    public static final String BASE_URL = "http://10.0.2.2:3000/";

    @GET("peliculas")
    Call<ArrayList<Peliculas>> obtenerPeliculas(@Query("_limit") String limite);
}
