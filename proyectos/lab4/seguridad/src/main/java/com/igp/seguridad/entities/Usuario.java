package com.igp.seguridad.entities;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")

public class Usuario  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String correo;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Rol> roles;

    public Usuario() {}

    public Usuario(Long id, String username, String correo) {
        this.id = id;
        this.username = username;
        this.correo = correo;
    }

    // Getters y setters

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getCorreo() { return correo; }

    public void setCorreo(String correo) { this.correo = correo; }

    public Set<Rol> getRoles() { return roles; }

    public void setRoles(Set<Rol> roles) { this.roles = roles; }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
}