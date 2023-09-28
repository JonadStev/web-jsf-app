package com.demo.app;

import java.io.Serializable;

public class Registro implements Serializable {
    private String id;
    private String nombre;
    private String apellidos;
    private String identificacion;
    private String correo;
    private String direccion;

    public Registro(){}
    public Registro(String id, String nombre, String apellidos, String identificacion, String correo, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.identificacion = identificacion;
        this.correo = correo;
        this.direccion = direccion;
    }

    public Registro(String nombre, String apellidos, String identificacion, String correo, String direccion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.identificacion = identificacion;
        this.correo = correo;
        this.direccion = direccion;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getCorreo() {
        return correo;
    }

    public String getDireccion() {
        return direccion;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}