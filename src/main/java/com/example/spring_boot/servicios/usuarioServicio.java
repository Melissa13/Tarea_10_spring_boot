package com.example.spring_boot.servicios;

import com.example.spring_boot.entidades.seguridad.usuario;
import com.example.spring_boot.repositorios.UserRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.util.List;

@SpringBootApplication
@Service
public class usuarioServicio {

    @Autowired
    private UserRepositorio userRepository;

    // Core Functions
    public boolean validateUserAccount(String username, String password){
        usuario usuario = userRepository.findByUsernameAndPassword(username, password);

        return (usuario != null);
    }

    public void createNewUserAccount(String username, String firstName, String lastName, String password){
        if(isUsernameTaken(username))
            throw new IllegalArgumentException("\n\nThe user name: " + username + " is already taken");
        else
            System.out.println(password);
            userRepository.save(new usuario(username, firstName, lastName, password, false));
    }

    public void deleteUserAccount(String username){
        userRepository.delete(userRepository.findByUsername(username));
    }

    public void makeUserAdmin(String username){
        usuario usuario = userRepository.findByUsername(username);
        if(!usuario.isAdmin()){
            usuario.setAdmin(true);
            userRepository.save(usuario);
        }
    }

    public List<usuario> findAllUsers(){
        return userRepository.findAll();
    }

    private boolean isUsernameTaken(String username){
        usuario user = userRepository.findByUsername(username);

        return (user != null);
    }

}
