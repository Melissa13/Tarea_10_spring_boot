package com.example.spring_boot.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.spring_boot.entidades.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AlquilerRepositorio extends JpaRepository<alquiler,Long>{
    @Query("select u from alquiler u where u.id = :id")
    alquiler buscar(@Param("id") Long id);
}
