package com.housecloud.appexamentoflama.RecyclerViewUtils;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.housecloud.appexamentoflama.Model.Peliculas;
import com.housecloud.appexamentoflama.R;

import java.util.ArrayList;

/**
 * Created by 21642432 on 28/02/2018.
 */

public class AdaptadorPeliculas extends RecyclerView.Adapter<AdaptadorPeliculas.VhPelicula> implements View.OnClickListener{

    private ArrayList<Peliculas> datos;
    private View.OnClickListener listener;

    public static class VhPelicula extends RecyclerView.ViewHolder {

        private TextView tvid;
        private TextView tvNombre;
        private TextView tvDirector;
        private TextView tvClasificacion;

        public VhPelicula(View itemView) {
            super(itemView);
            tvid = itemView.findViewById(R.id.tvid);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvDirector = itemView.findViewById(R.id.tvDirector);
            tvClasificacion = itemView.findViewById(R.id.tvClasificacion);
        }
    }

    public AdaptadorPeliculas(ArrayList<Peliculas> datos) {
        this.datos = datos;
    }

    @Override
    public VhPelicula onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pelicula, parent,false);
        v.setOnClickListener(this);
        VhPelicula vhp = new VhPelicula(v);
        return vhp;
    }

    @Override
    public void onBindViewHolder(VhPelicula holder, int position) {

        holder.tvid.setText(datos.get(position).getId());
        holder.tvNombre.setText(datos.get(position).getNombre());
        holder.tvDirector.setText(datos.get(position).getDirector());
        holder.tvClasificacion.setText(datos.get(position).getClasificacion());
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public void setOnClickListener(View.OnClickListener v) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if (listener != null) {
            listener.onClick(v);
        }
    }
}
