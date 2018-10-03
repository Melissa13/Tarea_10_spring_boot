package com.example.spring_boot.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.spring_boot.entidades.*;
import com.example.spring_boot.entidades.seguridad.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepositorio extends JpaRepository<usuario,String>{
    @Query("select u from usuario u where u.username = :username")
    usuario buscar(@Param("username") String username);
}
