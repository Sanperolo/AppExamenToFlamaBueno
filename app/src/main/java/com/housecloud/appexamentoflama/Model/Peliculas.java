package com.housecloud.appexamentoflama.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Peliculas {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("director")
    @Expose
    private String director;
    @SerializedName("clasificacion")
    @Expose
    private String clasificacion;

    public Integer getId() { return id; }

    public String getNombre() {
        return nombre;
    }

    public String getDirector() {
        return director;
    }

    public String getClasificacion() {
        return clasificacion;
    }
}