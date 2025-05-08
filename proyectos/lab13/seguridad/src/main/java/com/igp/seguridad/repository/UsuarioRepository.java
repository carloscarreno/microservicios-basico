package com.igp.seguridad.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.igp.seguridad.entities.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);
}