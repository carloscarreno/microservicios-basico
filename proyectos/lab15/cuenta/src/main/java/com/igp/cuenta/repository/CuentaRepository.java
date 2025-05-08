package com.igp.cuenta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igp.cuenta.entities.Cuenta;



public interface  CuentaRepository extends JpaRepository<Cuenta, Long>  {
     Cuenta findByIdUsuario(Long idUsuario);
}
