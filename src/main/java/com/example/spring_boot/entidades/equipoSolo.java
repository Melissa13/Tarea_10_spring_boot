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

    public equipoSolo(long id, equipos asociado, long cantidad, alquiler orden_alquiler) {
        this.id = id;
        this.asociado = asociado;
        this.cantidad = cantidad;
        this.orden_alquiler=orden_alquiler;
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

    public alquiler getOrden_alquiler() {
        return orden_alquiler;
    }

    public void setOrden_alquiler(alquiler orden_alquiler) {
        this.orden_alquiler = orden_alquiler;
    }
}
