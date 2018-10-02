package com.example.spring_boot.entidades.seguridad;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class rol implements Serializable{
    @Id
    private String rol;

    public rol() {
    }

    public rol(String rol) {
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
