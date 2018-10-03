package com.example.spring_boot.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.spring_boot.entidades.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EquiopoSoloRepositorio extends JpaRepository<equipoSolo,Long>{
    @Query("select u from equipoSolo u where u.id = :id")
    equipoSolo buscar(@Param("id") Long id);
}
