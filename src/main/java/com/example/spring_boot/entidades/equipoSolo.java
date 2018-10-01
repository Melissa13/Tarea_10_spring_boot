package com.example.spring_boot.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class equipoSolo implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne()
    private equipos asociado;
    private long cantidad;
    @ManyToOne()
    private alquiler orden_alquiler;

    public equipoSolo() {
    }

    public equipoSolo(long id, equipos asociado, long cantidad) {
        this.id = id;
        this.asociado = asociado;
        this.cantidad = cantidad;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public equipos getAsociado() {
        return asociado;
    }

    public void setAsociado(equipos asociado) {
        this.asociado = asociado;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }
}
