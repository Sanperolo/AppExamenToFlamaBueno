package com.housecloud.appexamentoflama;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.housecloud.appexamentoflama.Model.Peliculas;
import com.housecloud.appexamentoflama.RecyclerViewUtils.AdaptadorPeliculas;
import com.housecloud.appexamentoflama.RetrofitUtils.RestServicePelicula;
import com.housecloud.appexamentoflama.RetrofitUtils.RetrofitClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ListaPeliculasActivity extends AppCompatActivity {

    private int numPelicula;
    private ArrayList<Peliculas> listap;
    private RecyclerView rv;
    private LinearLayoutManager llm;
    private AdaptadorPeliculas ap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_peliculas);

        listap = new ArrayList<Peliculas>();

        numPelicula = getIntent().getIntExtra(getResources().getString(R.string.clave_num_pelicula),10);

        invorcarWS();
    }

    private void configurarRV() {
        rv = findViewById(R.id.RW);
        rv.setHasFixedSize(true);

        llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        ap = new AdaptadorPeliculas(listap);

        rv.setAdapter(ap);
    }

    private void invorcarWS() {
        if (isNetworkAvailable()){
            Retrofit rt = RetrofitClient.getClient(RestServicePelicula.BASE_URL);

            RestServicePelicula rsp = rt.create(RestServicePelicula.class);
            Call<ArrayList<Peliculas>> call = rsp.obtenerPeliculas(numPelicula+"");

            call.enqueue(new Callback<ArrayList<Peliculas>>() {

                @Override
                public void onResponse(Call<ArrayList<Peliculas>> call, Response<ArrayList<Peliculas>> response) {

                    if (!response.isSuccessful()) {
                        Log.e("Error", response.code()+"");
                    } else {
                        ArrayList<Peliculas> peliculas = response.body();

                        for (Peliculas peli : peliculas) {
                            listap.add(peli);
                        }

                    }
                    configurarRV();
                }

                @Override
                public void onFailure(Call<ArrayList<Peliculas>> call, Throwable t) {
                    Log.e("error", t.toString());
                }
            });
        }


    }

    private boolean isNetworkAvailable() {
        boolean isAvailable=false;
        //Gestor de conectividad
        ConnectivityManager manager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        //Objeto que recupera la información de la red
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        //Si la información de red no es nula y estamos conectados
        //la red está disponible
        if(networkInfo!=null && networkInfo.isConnected()){
            isAvailable=true;
        }
        return isAvailable;

    }
}
