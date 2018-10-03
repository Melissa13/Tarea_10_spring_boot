package com.example.spring_boot.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.spring_boot.entidades.*;

public interface ClientesRepositorio extends JpaRepository<clientes,Long>{
}
