package com.example.spring_boot.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.spring_boot.entidades.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EquiposRepositorio extends JpaRepository<equipos,Long>{
    @Query("select u from equipos u where u.id = :id")
    equipos buscar(@Param("id") Long id);
}
