package com.example.spring_boot.entidades;

import javax.persistence.*;
import java.io.Serializable;

public class equipos {

    private long id;
    private String nombre;
    private String familia;
    private String sub_familia;
    private long cantidad;
    private long costo;
    private byte imagen;

}
