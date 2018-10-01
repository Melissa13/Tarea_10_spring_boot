package com.example.spring_boot.entidades;

import java.util.Date;
import java.util.Set;

public class alquiler {

    private long id;
    private clientes cliente;
    private Set<equipoSolo> equipo;
    private Date fecha_prestamo;
    private Date fecha_entrega;
    private long dias;
}
