package com.example.spring_boot.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class clientes implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long cedula;
    private byte foto;
    private String nombre;
    private int edad;
    private String birth_place;
    private boolean genero;
    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
    private Set<historial> historiales;

    public clientes() {
    }

    public clientes(long id, long cedula, byte foto, String nombre, int edad, String birth_place, boolean genero, Set<historial> historiales) {
        this.id = id;
        this.cedula = cedula;
        this.foto = foto;
        this.nombre = nombre;
        this.edad = edad;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getBirth_place() {
        return birth_place;
    }

    public void setBirth_place(String birth_place) {
        this.birth_place = birth_place;
    }

    public boolean isGenero() {
        return genero;
    }

    public void setGenero(boolean genero) {
        this.genero = genero;
    }

    public Set<historial> getHistoriales() {
        return historiales;
    }

    public void setHistoriales(Set<historial> historiales) {
        this.historiales = historiales;
    }
}
