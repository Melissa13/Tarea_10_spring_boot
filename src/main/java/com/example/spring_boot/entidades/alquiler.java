package com.example.spring_boot.entidades;

import java.util.Date;
import java.util.Set;
import javax.persistence.*;
import java.io.Serializable;

@Entity
public class alquiler implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne()
    private clientes cliente;
    @OneToMany(mappedBy = "orden_alquiler", fetch = FetchType.EAGER)
    private Set<equipoSolo> equipo;
    @Temporal(TemporalType.DATE)
    private Date fecha_prestamo;
    @Temporal(TemporalType.DATE)
    private Date fecha_entrega;
    private long dias;
    private boolean pendiente=true;

    public alquiler() {
    }

    public alquiler(long id, clientes cliente, Set<equipoSolo> equipo, Date fecha_prestamo, Date fecha_entrega, long dias, boolean pendiente) {
        this.id = id;
        this.cliente = cliente;
        this.equipo = equipo;
        this.fecha_prestamo = fecha_prestamo;
        this.fecha_entrega = fecha_entrega;
        this.dias = dias;
        this.pendiente=pendiente;
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

    public Set<equipoSolo> getEquipo() {
        return equipo;
    }

    public void setEquipo(Set<equipoSolo> equipo) {
        this.equipo = equipo;
    }

    public Date getFecha_prestamo() {
        return fecha_prestamo;
    }

    public void setFecha_prestamo(Date fecha_prestamo) {
        this.fecha_prestamo = fecha_prestamo;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public long getDias() {
        return dias;
    }

    public void setDias(long dias) {
        this.dias = dias;
    }

    public boolean isPendiente() {
        return pendiente;
    }

    public void setPendiente(boolean pendiente) {
        this.pendiente = pendiente;
    }
}
