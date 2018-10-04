package com.example.spring_boot.entidades;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
public class clientes implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long cedula;
    private byte foto;
    private String nombre;
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date birth_date;
    private String birth_place;
    private String genero;
    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
    private Set<alquiler> historiales;
    private String extra;

    public clientes() {
    }

    public clientes(long id, long cedula, byte foto, String nombre, Date birth_date, String birth_place, String genero, Set<alquiler> historiales) {
        this.id = id;
        this.cedula = cedula;
        this.foto = foto;
        this.nombre = nombre;
        this.birth_date = birth_date;
        this.birth_place = birth_place;
        this.genero = genero;
        this.historiales=historiales;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public byte getFoto() {
        return foto;
    }

    public void setFoto(byte foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getBirth_place() {
        return birth_place;
    }

    public void setBirth_place(String birth_place) {
        this.birth_place = birth_place;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Set<alquiler> getHistoriales() {
        return historiales;
    }

    public void setHistoriales(Set<alquiler> historiales) {
        this.historiales = historiales;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
}
