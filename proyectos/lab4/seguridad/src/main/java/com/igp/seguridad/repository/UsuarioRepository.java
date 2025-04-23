package com.igp.seguridad.repository;

import org.springframework.data.repository.CrudRepository;
import com.igp.seguridad.entities.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
}