package com.example.spring_boot.entidades.seguridad;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class usuario {

    @Id
    private String username;
    private String password;
    private String name;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<rol> roles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<rol> roles) {
        this.roles = roles;
    }
}
