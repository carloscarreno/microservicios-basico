package com.igp.seguridad.repository;

import org.springframework.data.repository.CrudRepository;
import com.igp.seguridad.entities.Rol;

public interface RolRepository extends CrudRepository<Rol, Long> {
    Rol findByNombre(String nombre);
}