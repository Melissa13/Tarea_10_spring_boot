package com.example.spring_boot.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.spring_boot.entidades.*;
import com.example.spring_boot.entidades.seguridad.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RolRepositorio extends JpaRepository<rol,String>{
    @Query("select u from rol u where u.rol = :rol")
    rol buscar(@Param("rol") String rol);
}
