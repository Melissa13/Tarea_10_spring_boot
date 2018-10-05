package com.example.spring_boot.entidades;

import java.util.Calendar;
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
    private boolean activo=true;
    private String extra1;
    private String extra2;

    public alquiler() {
    }

    public alquiler(long id, clientes cliente, Set<equipoSolo> equipo, Date fecha_prestamo, Date fecha_entrega, long dias, boolean pendiente, String extra1, String extra2, boolean activo) {
        this.id = id;
        this.cliente = cliente;
        this.equipo = equipo;
        this.fecha_prestamo = fecha_prestamo;
        this.fecha_entrega = fecha_entrega;
        this.dias = dias;
        this.pendiente=pendiente;
        this.extra1=extra1;
        this.extra2=extra2;
        this.activo=activo;
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

    public String getExtra1() {
        return extra1;
    }

    public void setExtra1(String extra1) {
        this.extra1 = extra1;
    }

    public String getExtra2() {
        return extra2;
    }

    public void setExtra2(String extra2) {
        this.extra2 = extra2;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public long days(Date d1) {
        Date today = Calendar.getInstance().getTime();
        return (long) ( (d1.getTime() - today.getTime()) / (1000 * 60 * 60 * 24));
    }

    public long total(){
        long suma=0;

        for(equipoSolo e: equipo){
            suma+=e.getCantidad()*e.getAsociado().getCosto();
        }

        return suma;
    }

    public Long cantidade(){

        long suma=0;

        for(equipoSolo e: equipo){
            suma+=e.getCantidad();
        }

        return suma;

    }
}
