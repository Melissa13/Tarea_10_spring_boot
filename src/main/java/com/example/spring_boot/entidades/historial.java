package com.example.spring_boot.entidades;

import java.util.Date;
import javax.persistence.*;
import java.io.Serializable;

@Entity
public class historial implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne()
    private clientes cliente;
    @OneToOne()
    private equipos equipo;
    private long cantidad;
    private Date fecha;

    public historial() {
    }

    public historial(long id, clientes cliente, equipos equipo, long cantidad, Date fecha) {
        this.id = id;
        this.cliente = cliente;
        this.equipo = equipo;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public clientes getCliente() {
        return cliente;
    }

    public void setCliente(clientes cliente) {
        this.cliente = cliente;
    }

    public equipos getEquipo() {
        return equipo;
    }

    public void setEquipo(equipos equipo) {
        this.equipo = equipo;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
