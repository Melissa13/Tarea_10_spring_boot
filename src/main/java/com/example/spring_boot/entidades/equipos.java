package com.example.spring_boot.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class equipos implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String familia;
    private String sub_familia;
    private long cantidad;
    private long costo;
    private byte imagen;
    private long disponibles;

    public equipos() {
    }

    public equipos(long id, String nombre, String familia, String sub_familia, long cantidad, long costo, byte imagen, long disponibles) {
        this.id = id;
        this.nombre = nombre;
        this.familia = familia;
        this.sub_familia = sub_familia;
        this.cantidad = cantidad;
        this.costo = costo;
        this.imagen = imagen;
        this.disponibles=disponibles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getSub_familia() {
        return sub_familia;
    }

    public void setSub_familia(String sub_familia) {
        this.sub_familia = sub_familia;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public long getCosto() {
        return costo;
    }

    public void setCosto(long costo) {
        this.costo = costo;
    }

    public byte getImagen() {
        return imagen;
    }

    public void setImagen(byte imagen) {
        this.imagen = imagen;
    }

    public long getDisponibles() {
        return disponibles;
    }

    public void setDisponibles(long disponibles) {
        this.disponibles = disponibles;
    }
}
