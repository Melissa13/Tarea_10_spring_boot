package com.example.spring_boot.entidades;

public class equipoSolo {

    private long id;
    private equipos asociado;
    private long cantidad;

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
