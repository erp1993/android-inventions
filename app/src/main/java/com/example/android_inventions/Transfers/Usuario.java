package com.example.android_inventions.Transfers;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Usuario {

    public String correo;
    public String nombre;

    public Usuario(){

    }

    public Usuario(String correo, String nombre){
        this.correo = correo;
        this.nombre = nombre;
    }
}
