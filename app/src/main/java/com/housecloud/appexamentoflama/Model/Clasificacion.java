package com.housecloud.appexamentoflama.Model;

/**
 * Created by 21642432 on 28/02/2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Clasificacion {

    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("icono")
    @Expose
    private String icono;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

}