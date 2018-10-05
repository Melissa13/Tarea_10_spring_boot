package com.example.spring_boot.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.spring_boot.entidades.*;
import com.example.spring_boot.entidades.seguridad.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UserRepositorio extends JpaRepository<usuario,String>{

    usuario findByUsername(String username);

    @Query("select u from usuario u where u.username = :username and u.password = :password")
    usuario findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    @Query("select u from usuario u where u.username = :username")
    usuario buscar(@Param("username") String username);
}
